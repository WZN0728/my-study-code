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
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��4��13�� ����11:46:39
 */
public class CuratorSessionTest {

	private static final String CONNECTIONSTRING = "192.168.10.128:2181,192.168.10.129:2181,192.168.10.130:2181,192.168.10.131:2181";

	public static void main(String[] args) throws Exception {
		// �����Ự�����ַ�ʽ
		// 1.Normal��������
		CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(CONNECTIONSTRING, 5000, 5000,
				new ExponentialBackoffRetry(1000, 3));
		curatorFramework.start();// ʹ�����������������
		// 2.fluent�����ʽ���ã�namespace("/curator")ִ�в��ɹ�
		// CuratorFramework curatorFramework1 =
		// CuratorFrameworkFactory.builder().connectString(CONNECTIONSTRING)
		// .sessionTimeoutMs(5000).connectionTimeoutMs(5000).retryPolicy(new
		// ExponentialBackoffRetry(1000, 3))
		// .namespace("/curator").build();
		CuratorFramework curatorFramework1 = CuratorFrameworkFactory.builder().connectString(CONNECTIONSTRING)
				.sessionTimeoutMs(5000).connectionTimeoutMs(5000).retryPolicy(new ExponentialBackoffRetry(1000, 3))
				.build();
		curatorFramework1.start();
		System.out.println("���ӳɹ�������");
	}

	public static CuratorFramework getInstance() {
		CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(CONNECTIONSTRING, 5000, 5000,
				new ExponentialBackoffRetry(1000, 3));
		curatorFramework.start();
		System.out.println("���ӳɹ�������");
		return curatorFramework;
	}

}
