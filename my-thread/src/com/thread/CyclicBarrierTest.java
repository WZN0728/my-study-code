/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  CyclicBarrierTest.java
 * @Package com.thread
 * @Copyright: 2018 All rights reserved.
 */
package com.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName: CyclicBarrierTest
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��3��7�� ����10:50:00
 */
public class CyclicBarrierTest {

	static CyclicBarrier c = new CyclicBarrier(2);

	/**
	 * �����new CyclicBarrier(2)�޸ĳ�new CyclicBarrier(3)�������̺߳����̻߳���Զ�ȴ���
	 * ��Ϊû�е������߳�ִ��await��������û�е������̵߳������ϣ�����֮ǰ�������ϵ����� �̶߳��������ִ�С� @Title:
	 * main @Description: TODO(������һ�仰�����������������) @param: @param args @return:
	 * void @throws
	 */
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					c.await();
				} catch (Exception e) {
				}
				System.out.println(1);
			}
		}).start();
		try {
			c.await();
		} catch (Exception e) {
		}
		System.out.println(2);
	}

}
