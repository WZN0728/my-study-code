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
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��4��13�� ����3:27:05
 */
public class CuratorExampleClient extends LeaderSelectorListenerAdapter implements Closeable {

	private final String name;

	private final LeaderSelector leaderSelector;

	private final LongAdder count = new LongAdder();

	public CuratorExampleClient(CuratorFramework client, String name, String path) {
		this.name = name;
		this.leaderSelector = new LeaderSelector(client, path, this);
		leaderSelector.autoRequeue();// �Զ���
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
		System.out.println("����" + name + ",��������leader,�ȴ�ʱ��" + waitSeconds + ",�����쵼�Ĵ�����" + count.intValue());
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
