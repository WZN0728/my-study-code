/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  SynchronousQueueTest.java
 * @Package com.test
 * @Copyright: 2018 All rights reserved.
 */
package com.test;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName: SynchronousQueueTest
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��3��21�� ����5:16:42
 */
public class SynchronousQueueTest {

	/**
	 * ���������һ�������֣� һ�����洢Ԫ�ص��������С�ÿ�������������ȵ���һ���̵߳���
	 * �Ƴ�����������������һֱ��������״̬��������ͨ��Ҫ����Linked-BlockingQueue����̬��
	 * ������Executors.newCachedThreadPoolʹ����������� @Title: main @Description:
	 * TODO(������һ�仰�����������������) @param: @param args @param: @throws Exception @return:
	 * void @throws
	 */
	public static void main(String[] args) throws Exception {
		Object obj = new Object();
		SynchronousQueue sq = new SynchronousQueue();
		sq.add(obj);
		sq.put(obj);
	}

}
