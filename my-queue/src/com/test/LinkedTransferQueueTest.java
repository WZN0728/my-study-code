/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  LinkedTransferQueueTest.java
 * @Package com.test
 * @Copyright: 2018 All rights reserved.
 */
package com.test;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @ClassName: LinkedTransferQueueTest
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��3��21�� ����5:28:13
 */
public class LinkedTransferQueueTest {

	/**
	 * һ��������ṹ��ɵ��޽��������� @Title: main @Description:
	 * TODO(������һ�仰�����������������) @param: @param args @return: void @throws
	 */
	public static void main(String[] args) throws Exception {
		Object obj = new Object();
		LinkedTransferQueue ltq = new LinkedTransferQueue();
		ltq.add(obj);
		ltq.put(obj);
	}

}
