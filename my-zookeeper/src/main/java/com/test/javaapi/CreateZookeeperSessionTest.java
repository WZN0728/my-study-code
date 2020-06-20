/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  ZookeeperTest.java
 * @Package com.test
 * @Copyright: 2018 All rights reserved.
 */
package com.test.javaapi;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * @ClassName: ZookeeperTest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月10日 下午9:00:59
 */
public class CreateZookeeperSessionTest {

	private static final String CONNECTSTRING = "192.168.10.128:2181,192.168.10.129:2181,192.168.10.130:2181,192.168.10.131:2181";

	private static CountDownLatch countDownLatch = new CountDownLatch(1);

	public static void main(String[] args) throws Exception {
		ZooKeeper zookeeper = new ZooKeeper(CONNECTSTRING, 5000, new Watcher() {

			@Override
			public void process(WatchedEvent event) {
				// TODO Auto-generated method stub
				if (event.getState() == Event.KeeperState.SyncConnected) {
					countDownLatch.countDown();
					System.out.println("zookeeper的链接状态：" + event.getState());
				}
			}
		});
		countDownLatch.await();
		System.out.println("zookeeper的假链接状态：" + zookeeper.getState());
	}

}
