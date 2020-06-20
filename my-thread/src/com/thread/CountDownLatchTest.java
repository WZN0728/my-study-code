/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  CountDownLatchTest.java
 * @Package com.thread
 * @Copyright: 2018 All rights reserved.
 */
package com.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: CountDownLatchTest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年3月6日 下午6:35:28
 */
public class CountDownLatchTest {
	static CountDownLatch c = new CountDownLatch(2);

	/**
	 * CountDownLatch允许一个或多个线程等待其他线程完成操作。
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param: @param args
	 * @param: @throws InterruptedException
	 * @return: void
	 * @throws
	 */
	public static void main(String[] args) throws InterruptedException {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(1);
				c.countDown();
				System.out.println(2);
				c.countDown();
			}
		}).start();
		c.await();
		System.out.println("3");
	}
	
	public void test() throws Exception{
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.isTerminated();
		es.awaitTermination(1, TimeUnit.DAYS);
		es.shutdown();
	}
	
}
