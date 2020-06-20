/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  CuratorSessionTeste.java
 * @Package com.test.curator
 * @Copyright: 2018 All rights reserved.
 */
package com.test.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @ClassName: CuratorSessionTeste
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月13日 上午11:46:39
 */
public class CuratorSessionTest {

	private static final String CONNECTIONSTRING = "192.168.10.128:2181,192.168.10.129:2181,192.168.10.130:2181,192.168.10.131:2181";

	public static void main(String[] args) throws Exception {
		// 创建会话得两种方式
		// 1.Normal正常创建
		CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(CONNECTIONSTRING, 5000, 5000,
				new ExponentialBackoffRetry(1000, 3));
		curatorFramework.start();// 使用这个方法创建链接
		// 2.fluent风格（链式调用）namespace("/curator")执行不成功
		// CuratorFramework curatorFramework1 =
		// CuratorFrameworkFactory.builder().connectString(CONNECTIONSTRING)
		// .sessionTimeoutMs(5000).connectionTimeoutMs(5000).retryPolicy(new
		// ExponentialBackoffRetry(1000, 3))
		// .namespace("/curator").build();
		CuratorFramework curatorFramework1 = CuratorFrameworkFactory.builder().connectString(CONNECTIONSTRING)
				.sessionTimeoutMs(5000).connectionTimeoutMs(5000).retryPolicy(new ExponentialBackoffRetry(1000, 3))
				.build();
		curatorFramework1.start();
		System.out.println("链接成功！！！");
	}

	public static CuratorFramework getInstance() {
		CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(CONNECTIONSTRING, 5000, 5000,
				new ExponentialBackoffRetry(1000, 3));
		curatorFramework.start();
		System.out.println("链接成功！！！");
		return curatorFramework;
	}

}
