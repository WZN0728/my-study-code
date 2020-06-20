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
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月13日 下午1:45:11
 */
public class CuratorOperationTest {

	private static Stat stat = new Stat();

	public static void main(String[] args) throws Exception {
		CuratorFramework curatorFramework = CuratorSessionTest.getInstance();
		// fluent风格
		// 创建节点
		String createResult = curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)
				.forPath("/curator/curator1/curator/1-1", "curator".getBytes());
		System.out.println("create -> " + createResult);
		// 更新节点
		curatorFramework.setData().forPath("/curator", "456".getBytes());
		// 获取节点
		String getResult = curatorFramework.getData().storingStatIn(stat).forPath("/curator").toString();
		System.out.println("get -> " + getResult);
		// 删除节点
		curatorFramework.delete().deletingChildrenIfNeeded().forPath("/curator");
		System.out.println("删除成功!!!");
		// 异步操作
		ExecutorService service = Executors.newSingleThreadExecutor();
		CountDownLatch countDownLatch = new CountDownLatch(1);
		curatorFramework.create().creatingParentsIfNeeded().inBackground(new BackgroundCallback() {
			@Override
			public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("异步创建：" + client.getNamespace() + "->" + event.getPath() + "->" + event.getStat()
						+ "->" + event.getType() + "->" + event.getName() + "->" + event.getData());
				countDownLatch.countDown();
			}
		}, service).forPath("/curator", "456".getBytes());
		countDownLatch.await();
		service.shutdown();
		// 事物（curator独有）stat其实就是参数得一些封装，可以看作是一个bean
		Collection<CuratorTransactionResult> resultSet = curatorFramework.inTransaction().create()
				.forPath("/trans", "事物".getBytes()).and().setData().forPath("/curator", "修改事务".getBytes()).and()
				.commit();
		for (CuratorTransactionResult result : resultSet) {
			System.out.println(result.getForPath() + " -> " + result.getType() + "->" + result.getResultPath() + "->"
					+ result.getResultStat());
		}
	}

}
