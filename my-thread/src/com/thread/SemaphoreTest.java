/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  SemaphoreTest.java
 * @Package com.thread
 * @Copyright: 2018 All rights reserved.
 */
package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName: SemaphoreTest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年3月7日 上午11:04:58
 */
public class SemaphoreTest {

	private static final int THREAD_COUNT = 30;

	private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

	private static Semaphore s = new Semaphore(10);

	/**
	 * Semaphore（信号量）是用来控制同时访问特定资源的线程数量，它通过协调各个线程，以 保证合理的使用公共资源。
	 * 多年以来，我都觉得从字面上很难理解Semaphore所表达的含义，只能把它比作是控制流
	 * 量的红绿灯。比如××马路要限制流量，只允许同时有一百辆车在这条路上行使，其他的都必须
	 * 在路口等待，所以前一百辆车会看到绿灯，可以开进这条马路，后面的车会看到红灯，不能驶
	 * 入××马路，但是如果前一百辆中有5辆车已经离开了××马路，那么后面就允许有5辆车驶入马
	 * 路，这个例子里说的车就是线程，驶入马路就表示线程在执行，离开马路就表示线程执行完 成，看见红灯就表示线程被阻塞，不能执行。 @Title:
	 * main @Description: TODO(这里用一句话描述这个方法的作用) @param: @param args @return:
	 * void @throws
	 */
	public static void main(String[] args) {
		for (int i = 0; i < THREAD_COUNT; i++) {
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						//Semaphore的acquire()方法获取一个许可证
						s.acquire();
						System.out.println("save data");
						//使用完之后调用release()方法归还许可证,还可以用tryAcquire()方法尝试获取许可证。
						s.release();
					} catch (InterruptedException e) {
					}
				}
			});
		}
		threadPool.shutdown();
	}

}
