/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  LinkedBlockingQueueTest.java
 * @Package com.test
 * @Copyright: 2018 All rights reserved.
 */
package com.test;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName: LinkedBlockingQueueTest
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��3��21�� ����5:12:04
 */
public class LinkedBlockingQueueTest {

	/**
	 * һ����������ṹ���������У��˶��а�FIFO����Ԫ�أ�������ͨ
	 * ��Ҫ����ArrayBlockingQueue����̬��������Executors.newFixedThreadPool()ʹ����������� @Title:
	 * main @Description: TODO(������һ�仰�����������������) @param: @param args @param: @throws
	 * Exception @return: void @throws
	 */
	public static void main(String[] args) throws Exception {
		Object obj = new Object();
		LinkedBlockingQueue lbq = new LinkedBlockingQueue();
		lbq.put(obj);
	}

}
