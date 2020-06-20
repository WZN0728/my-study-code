/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  CuratorEventTest.java
 * @Package com.test.curator
 * @Copyright: 2018 All rights reserved.
 */
package com.test.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.zookeeper.CreateMode;

/**
 * @ClassName: CuratorEventTest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月13日 下午2:23:14
 */
public class CuratorEventTest {

	/**
	 * 三种watcher来做节点的监听 pathcache 监视一个路径下子节点的创建、删除、节点数据更新 NodeCache 监视一个节点的创建、更新、删除
	 * TreeCache pathcaceh+nodecache 的合体（监视路径下的创建、更新、删除事件）， 缓存路径下的所有子节点的数据
	 */
	public static void main(String[] args) throws Exception {
		// NodeCache 监视一个节点的创建、更新、删除
		CuratorFramework curatorFramework = CuratorSessionTest.getInstance();
		NodeCache nodeCache = new NodeCache(curatorFramework, "/curator", false);
		nodeCache.start(true);
		nodeCache.getListenable().addListener(() -> {
			System.out.println("节点数据变化后得结果：" + new String(nodeCache.getCurrentData().getData()));
		});
		curatorFramework.setData().forPath("/curator", "123".getBytes());
		// PathCaceh监视一个路径下子节点的创建、删除、节点数据更新
		PathChildrenCache pathChildrenCache = new PathChildrenCache(curatorFramework, "/curator", false);
		pathChildrenCache.start(true);
		pathChildrenCache.getListenable().addListener((client, event) -> {
			switch (event.getType()) {
			case CHILD_ADDED:
				System.out.println("增加子节点");
				break;
			case CHILD_UPDATED:
				System.out.println("更新子节点");
			case CHILD_REMOVED:
				System.out.println("删除子节点");
			default:
				break;
			}
		});
		curatorFramework.create().withMode(CreateMode.PERSISTENT).forPath("/curator/curator1", "456".getBytes());
		curatorFramework.setData().forPath("/curator/curator1", "456".getBytes());
		System.out.println("1");
		Thread.sleep(2);
		curatorFramework.setData().forPath("/curator/curator1", "789".getBytes());
		System.out.println("2");
		Thread.sleep(2);
		curatorFramework.delete().forPath("/curator/curator1");
		System.out.println("3");
		// TreeCache pathcaceh+nodecache 的合体（监视路径下的创建、更新、删除事件）
		TreeCache treeCache = new TreeCache(curatorFramework, "/curator");
		treeCache.start();
		treeCache.getListenable().addListener((client, event) -> {
			switch (event.getType()) {
			case NODE_ADDED:
				System.out.println("增加节点");
				break;
			case NODE_UPDATED:
				System.out.println("更新节点");
				break;
			case NODE_REMOVED:
				System.out.println("删除节点");
				break;
			default:
				break;
			}
		});
		curatorFramework.create().withMode(CreateMode.PERSISTENT).forPath("/curator/curator1", "123".getBytes());
		curatorFramework.setData().forPath("/curator/curator1", "456".getBytes());
		Thread.sleep(5);
		System.out.println("treecache1");
		curatorFramework.setData().forPath("/curator", "789".getBytes());
		Thread.sleep(5);
		System.out.println("treecache2");
		curatorFramework.delete().forPath("/curator/curator1");
		System.in.read();
	}

}
