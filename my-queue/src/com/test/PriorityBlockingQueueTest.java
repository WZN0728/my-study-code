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
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年3月21日 下午5:22:51
 */
public class PriorityBlockingQueueTest {

	/**
	 * 一个具有优先级的无限阻塞队列 
	 * maximumPoolSize（线程池最大数量）：线程池允许创建的最大线程数。如果队列满了，并
	 * 且已创建的线程数小于最大线程数，则线程池会再创建新的线程执行任务。值得注意的是，如 果使用了无界的任务队列这个参数就没什么效果 @Title:
	 * main @Description: TODO(这里用一句话描述这个方法的作用) @param: @param args @return:
	 * void @throws
	 */
	public static void main(String[] args) {
		Object obj = new Object();
		PriorityBlockingQueue pbq = new PriorityBlockingQueue();
		pbq.add(obj);
		pbq.put(obj);
	}

}
