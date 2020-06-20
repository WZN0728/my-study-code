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
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年3月21日 下午5:16:42
 */
public class SynchronousQueueTest {

	/**
	 * 这个队列是一个传球手， 一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用
	 * 移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高于Linked-BlockingQueue，静态工
	 * 厂方法Executors.newCachedThreadPool使用了这个队列 @Title: main @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param: @param args @param: @throws Exception @return:
	 * void @throws
	 */
	public static void main(String[] args) throws Exception {
		Object obj = new Object();
		SynchronousQueue sq = new SynchronousQueue();
		sq.add(obj);
		sq.put(obj);
	}

}
