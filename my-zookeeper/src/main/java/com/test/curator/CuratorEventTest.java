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
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��4��13�� ����2:23:14
 */
public class CuratorEventTest {

	/**
	 * ����watcher�����ڵ�ļ��� pathcache ����һ��·�����ӽڵ�Ĵ�����ɾ�����ڵ����ݸ��� NodeCache ����һ���ڵ�Ĵ��������¡�ɾ��
	 * TreeCache pathcaceh+nodecache �ĺ��壨����·���µĴ��������¡�ɾ���¼����� ����·���µ������ӽڵ������
	 */
	public static void main(String[] args) throws Exception {
		// NodeCache ����һ���ڵ�Ĵ��������¡�ɾ��
		CuratorFramework curatorFramework = CuratorSessionTest.getInstance();
		NodeCache nodeCache = new NodeCache(curatorFramework, "/curator", false);
		nodeCache.start(true);
		nodeCache.getListenable().addListener(() -> {
			System.out.println("�ڵ����ݱ仯��ý����" + new String(nodeCache.getCurrentData().getData()));
		});
		curatorFramework.setData().forPath("/curator", "123".getBytes());
		// PathCaceh����һ��·�����ӽڵ�Ĵ�����ɾ�����ڵ����ݸ���
		PathChildrenCache pathChildrenCache = new PathChildrenCache(curatorFramework, "/curator", false);
		pathChildrenCache.start(true);
		pathChildrenCache.getListenable().addListener((client, event) -> {
			switch (event.getType()) {
			case CHILD_ADDED:
				System.out.println("�����ӽڵ�");
				break;
			case CHILD_UPDATED:
				System.out.println("�����ӽڵ�");
			case CHILD_REMOVED:
				System.out.println("ɾ���ӽڵ�");
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
		// TreeCache pathcaceh+nodecache �ĺ��壨����·���µĴ��������¡�ɾ���¼���
		TreeCache treeCache = new TreeCache(curatorFramework, "/curator");
		treeCache.start();
		treeCache.getListenable().addListener((client, event) -> {
			switch (event.getType()) {
			case NODE_ADDED:
				System.out.println("���ӽڵ�");
				break;
			case NODE_UPDATED:
				System.out.println("���½ڵ�");
				break;
			case NODE_REMOVED:
				System.out.println("ɾ���ڵ�");
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
