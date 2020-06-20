/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  LinkedBlockingQueueTest.java
 * @Package com.test
 * @Copyright: 2018 All rights reserved.
 */
package com.test;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName: LinkedBlockingQueueTest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年3月21日 下午5:12:04
 */
public class LinkedBlockingQueueTest {

	/**
	 * 一个基于链表结构的阻塞队列，此队列按FIFO排序元素，吞吐量通
	 * 常要高于ArrayBlockingQueue。静态工厂方法Executors.newFixedThreadPool()使用了这个队列 @Title:
	 * main @Description: TODO(这里用一句话描述这个方法的作用) @param: @param args @param: @throws
	 * Exception @return: void @throws
	 */
	public static void main(String[] args) throws Exception {
		Object obj = new Object();
		LinkedBlockingQueue lbq = new LinkedBlockingQueue();
		lbq.put(obj);
	}

}
