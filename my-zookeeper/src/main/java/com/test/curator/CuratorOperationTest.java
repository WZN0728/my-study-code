/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  CuratorOperationTest.java
 * @Package com.test.curator
 * @Copyright: 2018 All rights reserved.
 */
package com.test.curator;

import java.util.Collection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.transaction.CuratorTransactionResult;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * @ClassName: CuratorOperationTest
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��4��13�� ����1:45:11
 */
public class CuratorOperationTest {

	private static Stat stat = new Stat();

	public static void main(String[] args) throws Exception {
		CuratorFramework curatorFramework = CuratorSessionTest.getInstance();
		// fluent���
		// �����ڵ�
		String createResult = curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)
				.forPath("/curator/curator1/curator/1-1", "curator".getBytes());
		System.out.println("create -> " + createResult);
		// ���½ڵ�
		curatorFramework.setData().forPath("/curator", "456".getBytes());
		// ��ȡ�ڵ�
		String getResult = curatorFramework.getData().storingStatIn(stat).forPath("/curator").toString();
		System.out.println("get -> " + getResult);
		// ɾ���ڵ�
		curatorFramework.delete().deletingChildrenIfNeeded().forPath("/curator");
		System.out.println("ɾ���ɹ�!!!");
		// �첽����
		ExecutorService service = Executors.newSingleThreadExecutor();
		CountDownLatch countDownLatch = new CountDownLatch(1);
		curatorFramework.create().creatingParentsIfNeeded().inBackground(new BackgroundCallback() {
			@Override
			public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("�첽������" + client.getNamespace() + "->" + event.getPath() + "->" + event.getStat()
						+ "->" + event.getType() + "->" + event.getName() + "->" + event.getData());
				countDownLatch.countDown();
			}
		}, service).forPath("/curator", "456".getBytes());
		countDownLatch.await();
		service.shutdown();
		// ���curator���У�stat��ʵ���ǲ�����һЩ��װ�����Կ�����һ��bean
		Collection<CuratorTransactionResult> resultSet = curatorFramework.inTransaction().create()
				.forPath("/trans", "����".getBytes()).and().setData().forPath("/curator", "�޸�����".getBytes()).and()
				.commit();
		for (CuratorTransactionResult result : resultSet) {
			System.out.println(result.getForPath() + " -> " + result.getType() + "->" + result.getResultPath() + "->"
					+ result.getResultStat());
		}
	}

}
