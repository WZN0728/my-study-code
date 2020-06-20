/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  ThreadPoolExecutorTest.java
 * @Package com.thread
 * @Copyright: 2018 All rights reserved.
 */
package com.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: ThreadPoolExecutorTest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月11日 下午2:43:50
 */
public class ThreadPoolExecutorTest extends ThreadPoolExecutor{

	/**
	 * corePoolSize, 核心线程数
	 * maximumPoolSize, 最大的线程数
	 * keepAliveTime, 具体的存活时间，也就是赋值
	 * unit, TimeUnit的类型，天/小时/分钟/秒数
	 * workQueue, 等待队列，当corePoolSize已满时，进入当前的等待队列
	 * threadFactory, 定义当前子线程的名字，便于在出现异常时的回溯
	 * handler, 自定义的句柄事件，如果当前的核心线程，等待队列，已经非核心线程都满了，那么可以自定义饱和策略，可以讲当前的请求线程存入到一个队列或者持久化的数据库，以便将来拿出来在执行
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param: @param args
	 * @return: void
	 * @throws
	 */
	public static void main(String[] args) {
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 20, 10, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				// TODO Auto-generated method stub
				return null;
			}
		}, new RejectedExecutionHandler() {
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				// TODO Auto-generated method stub
			}
		});
	}

	/**
	 * author:wuting
	 * 
	 * @param corePoolSize
	 *            线程池的核心线程数
	 * @param maximumPoolSize
	 *            线程池中的最大线程数（超过核心线程数并且在最大线程数中的线程为非核心线程，此值与核心线程的值设置相同，则没有非核心线程）
	 * @param keepAliveTime
	 *            阈值时间，会根据此时间定期清理没有执行任务的核心线程和非核心线程
	 * @param unit
	 *            设定阈值时间的单位（时、分、秒）
	 * @param blockingQueue
	 *            等待队列
	 * @param threadName
	 *            线程名（设置线程名称方便出问题时回溯）
	 */
	public ThreadPoolExecutorTest(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			int blockingQueue, final String threadName) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, new ArrayBlockingQueue<Runnable>(blockingQueue),
				new ThreadFactory() {
					@Override
					public Thread newThread(Runnable r) {
						// TODO Auto-generated method stub
						return new Thread(r, "线程名称[" + threadName + "]:" + r.hashCode());
					}
				}, new RejectedExecutionHandler() {
					@Override
					public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
						// TODO Auto-generated method stub
						executor.execute(r);
					}
				});
	}
	
}
