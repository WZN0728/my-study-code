/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  DelayQueueTest.java
 * @Package com.test
 * @Copyright: 2018 All rights reserved.
 */
package com.test;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

/**
 * @ClassName: DelayQueueTest
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��3��21�� ����5:27:03
 */
public class DelayQueueTest {

	/**
	 * һ��ʹ�����ȼ�����ʵ�ֵ��޽��������� @Title: main @Description:
	 * TODO(������һ�仰�����������������) @param: @param args @return: void @throws
	 */
	public static void main(String[] args) throws Exception {
		Object obj = new Object();
		DelayQueue<Delayed> dq = new DelayQueue();
		dq.add((Delayed) obj);
		dq.put((Delayed) obj);
	}

}
