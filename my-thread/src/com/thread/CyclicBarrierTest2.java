/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  CyclicBarrierTest2.java
 * @Package com.thread
 * @Copyright: 2018 All rights reserved.
 */
package com.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName: CyclicBarrierTest2
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��3��7�� ����10:52:48
 */
public class CyclicBarrierTest2 {

	static CyclicBarrier c = new CyclicBarrier(2, new A());

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

	static class A implements Runnable {
		@Override
		public void run() {
			System.out.println(3);
		}
	}

}
