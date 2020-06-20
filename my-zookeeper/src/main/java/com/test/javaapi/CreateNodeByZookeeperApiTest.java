/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  CreateNodeTest.java
 * @Package com.test
 * @Copyright: 2018 All rights reserved.
 */
package com.test.javaapi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;

/**
 * @ClassName: CreateNodeTest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月10日 下午9:14:52
 */
public class CreateNodeByZookeeperApiTest implements Watcher {

	private static final String CONNECTSTRING = "192.168.10.128:2181,192.168.10.129:2181,192.168.10.130:2181,192.168.10.131:2181";

	private static CountDownLatch countDownLatch = new CountDownLatch(1);

	private static ZooKeeper zookeeper;

	private static Stat stat = new Stat();

	public static void main(String[] args) throws Exception {
		zookeeper = new ZooKeeper(CONNECTSTRING, 5000, new CreateNodeByZookeeperApiTest());
		System.out.println("zookeeper的链接状态：" + zookeeper.getState());
		countDownLatch.await();
		/*ACL acl = new ACL(ZooDefs.Perms.ALL,new Id("ip","192.168.11.129"));
		List<ACL> list = new ArrayList<ACL>();
		list.add(acl);
		zookeeper.exists("/auth", true);
		zookeeper.create("/auth", "test".getBytes(), list, CreateMode.PERSISTENT);*/
		String createResult = zookeeper.create("/node", "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
				CreateMode.PERSISTENT);
		System.out.println(createResult);
		zookeeper.setData("/node", "456".getBytes(), -1);
		Thread.sleep(2);
		String createChildResult = zookeeper.create("/node/node1", "111".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
				CreateMode.PERSISTENT);
		System.out.println(createChildResult);
		zookeeper.setData("/node/node1", "333".getBytes(), -1);
		Thread.sleep(2);
//		zookeeper.delete("/node/node1", -1);
		Thread.sleep(2);
		zookeeper.setData("/node", "666".getBytes(), -1);
		Thread.sleep(2);
		System.in.read();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.zookeeper.Watcher#process(org.apache.zookeeper.WatchedEvent)
	 */
	@Override
	public void process(WatchedEvent watchedEvent) {
		// TODO Auto-generated method stub
		if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
			if (Event.EventType.None == watchedEvent.getType() && null == watchedEvent.getPath()) {
				System.out.println(watchedEvent.getState() + "->" + watchedEvent.getType());
				countDownLatch.countDown();
			} else if (watchedEvent.getType() == Event.EventType.NodeCreated) {
				try {
					System.out.println("创建节点数据后的变更1" + watchedEvent.getState() + "->" + watchedEvent.getType());
					System.out.println("创建节点数据后的变更1" + zookeeper.getData(watchedEvent.getPath(), true, stat));
				} catch (KeeperException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (watchedEvent.getType() == Event.EventType.NodeDeleted) {
				System.out.println("删除节点数据后的变更" + watchedEvent.getState() + "->" + watchedEvent.getType());
			} else if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
				try {
					System.out.println("修改节点数据后的变更" + watchedEvent.getState() + "->" + watchedEvent.getType());
					System.out.println("修改节点数据后的变更1" + zookeeper.getData(watchedEvent.getPath(), true, stat));
				} catch (KeeperException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged) {
				try {
					System.out.println("修改子节点后的变更" + watchedEvent.getState() + "->" + watchedEvent.getType());
					System.out.println("修改子节点后的变更1" + zookeeper.getData(watchedEvent.getPath(), true, stat));
				} catch (KeeperException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
