/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  AuthControlTest.java
 * @Package com.test.javaapi
 * @Copyright: 2018 All rights reserved.
 */
package com.test.javaapi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;

/**
 * @ClassName: AuthControlTest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月13日 上午10:11:18
 */
public class AuthControlTest implements Watcher {

	private static final String CONNECTIONSTRING = "192.168.10.128:2181,192.168.10.129:2181,192.168.10.130:2181,192.168.10.131:2181";

	private static CountDownLatch countDownLatch1 = new CountDownLatch(1);

	private static ZooKeeper zookeeper;

	private static ZooKeeper zookeeper2;

	private static Stat stat = new Stat();

	public static void main(String[] args) throws Exception {
		zookeeper = new ZooKeeper(CONNECTIONSTRING, 5000, new AuthControlTest());
		countDownLatch1.await();
		ACL acl1 = new ACL(ZooDefs.Perms.CREATE, new Id("digest", "root:root"));
		ACL acl2 = new ACL(ZooDefs.Perms.CREATE, new Id("ip", "192.168.1.1"));
		List<ACL> list = new ArrayList<ACL>();
		list.add(acl1);
		list.add(acl2);
		zookeeper.create("/auth1", "auth1".getBytes(), list, CreateMode.PERSISTENT);
		zookeeper.addAuthInfo("digest", "root:root".getBytes());
		// zookeeper.create("/auth1", "auth1".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL,
		// CreateMode.PERSISTENT);
		zookeeper.create("/auth1/auth1-1", "123".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.EPHEMERAL);

		zookeeper2 = new ZooKeeper(CONNECTIONSTRING, 5000, new AuthControlTest());
		countDownLatch1.await();
		zookeeper2.delete("/auth1/auth1-1", -1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.zookeeper.Watcher#process(org.apache.zookeeper.WatchedEvent)
	 */
	@Override
	public void process(WatchedEvent event) {
		// TODO Auto-generated method stub
		if (event.getState() == Event.KeeperState.SyncConnected) {
			if (event.getType() == Event.EventType.None && null == event.getPath()) {
				countDownLatch1.countDown();
				System.out.println(event.getPath() + "->" + event.getState());
			}
		}
	}

}
