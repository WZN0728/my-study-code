/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  CuratorExampleClient.java
 * @Package com.test.curator
 * @Copyright: 2018 All rights reserved.
 */
package com.test.curator;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;

/**
 * @ClassName: CuratorExampleClient
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月13日 下午3:27:05
 */
public class CuratorExampleClient extends LeaderSelectorListenerAdapter implements Closeable {

	private final String name;

	private final LeaderSelector leaderSelector;

	private final LongAdder count = new LongAdder();

	public CuratorExampleClient(CuratorFramework client, String name, String path) {
		this.name = name;
		this.leaderSelector = new LeaderSelector(client, path, this);
		leaderSelector.autoRequeue();// 自动抢
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.curator.framework.recipes.leader.LeaderSelectorListener#
	 * takeLeadership(org.apache.curator.framework.CuratorFramework)
	 */
	@Override
	public void takeLeadership(CuratorFramework client) throws Exception {
		// TODO Auto-generated method stub
		final int waitSeconds = new Random().nextInt(50);
		count.increment();
		System.out.println("我是" + name + ",我现在是leader,等待时间" + waitSeconds + ",抢到领导的次数：" + count.intValue());
	}

	public void start() throws Exception {
		leaderSelector.start();
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		leaderSelector.close();
	}

}
