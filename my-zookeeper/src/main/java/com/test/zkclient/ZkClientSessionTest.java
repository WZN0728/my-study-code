/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  ZkClientSessionTest.java
 * @Package com.test.zkclient
 * @Copyright: 2018 All rights reserved.
 */
package com.test.zkclient;

import org.I0Itec.zkclient.ZkClient;

/**
 * @ClassName: ZkClientSessionTest
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��4��13�� ����10:49:13
 */
public class ZkClientSessionTest {

	private static final String CONNECTIONSTRING = "192.168.10.128:2181,192.168.10.129:2181,192.168.10.130:2181,192.168.10.131:2181";

	public static void main(String[] args) {
		ZkClient zkClient = new ZkClient(CONNECTIONSTRING, 5000);
		System.out.println("success -> " + zkClient);
	}

}
