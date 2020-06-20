/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  DeadLockTest.java
 * @Package com.thread
 * @Copyright: 2018 All rights reserved.
 */
package com.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: DeadLockTest
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��3��9�� ����10:57:20
 */
public class DeadLockTest {

	private static String A = "A";
	private static String B = "B";

	public static void main(String[] args) {
		new DeadLockTest().deadLock();
	}

	private void deadLock() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (A) {
					try {
						Thread.currentThread().sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (B) {
						System.out.println("1");
					}
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (B) {
					synchronized (A) {
						System.out.println("2");
					}
				}
			}
		});
		t1.start();
		t2.start();
	}

}
