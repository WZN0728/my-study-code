/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  JoinTest.java
 * @Package com.thread
 * @Copyright: 2018 All rights reserved.
 */
package com.thread;

/**
 * @ClassName: JoinTest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年3月7日 上午10:15:13
 */
public class JoinTest {

	static Thread thread1 = new Thread(new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("thread1");
		}
	});

	static Thread thread2 = new Thread(new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("thread2");
		}
	});

	static Thread thread3 = new Thread(new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("thread3");
		}
	});

	/**
	 * join用于让当前执行线程等待join线程执行结束。其实现原理是不停检查join线程是否存
	 * 活，如果join线程存活则让当前线程永远等待。其中，wait（0）表示永远等待下去，代码片段如 下。 while (isAlive()) {
	 * wait(0); } 直到join线程中止后，线程的this.notifyAll()方法会被调用，调用notifyAll()方法是在JVM里
	 * 实现的，所以在JDK里看不到，大家可以查看JVM源码。
	 * 在JDK1.5之后的并发包中提供的CountDownLatch也可以实现join的功能，并且比join的功 能更多
	 * {@link java.util.concurrent.CountDownLatch}
	 */
	public static void main(String[] args) throws Exception {
		thread1.start();
		thread1.join();
		thread2.start();
		thread2.join();
		thread3.start();
	}

}
