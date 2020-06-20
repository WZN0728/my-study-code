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
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年3月7日 上午10:50:00
 */
public class CyclicBarrierTest {

	static CyclicBarrier c = new CyclicBarrier(2);

	/**
	 * 如果把new CyclicBarrier(2)修改成new CyclicBarrier(3)，则主线程和子线程会永远等待，
	 * 因为没有第三个线程执行await方法，即没有第三个线程到达屏障，所以之前到达屏障的两个 线程都不会继续执行。 @Title:
	 * main @Description: TODO(这里用一句话描述这个方法的作用) @param: @param args @return:
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
