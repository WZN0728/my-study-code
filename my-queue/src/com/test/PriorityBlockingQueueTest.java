/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  PriorityBlockingQueueTest.java
 * @Package com.test
 * @Copyright: 2018 All rights reserved.
 */
package com.test;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @ClassName: PriorityBlockingQueueTest
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��3��21�� ����5:22:51
 */
public class PriorityBlockingQueueTest {

	/**
	 * һ���������ȼ��������������� 
	 * maximumPoolSize���̳߳�������������̳߳�������������߳���������������ˣ���
	 * ���Ѵ������߳���С������߳��������̳߳ػ��ٴ����µ��߳�ִ������ֵ��ע����ǣ��� ��ʹ�����޽������������������ûʲôЧ�� @Title:
	 * main @Description: TODO(������һ�仰�����������������) @param: @param args @return:
	 * void @throws
	 */
	public static void main(String[] args) {
		Object obj = new Object();
		PriorityBlockingQueue pbq = new PriorityBlockingQueue();
		pbq.add(obj);
		pbq.put(obj);
	}

}
