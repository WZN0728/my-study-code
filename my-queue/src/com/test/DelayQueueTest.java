/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  DelayQueueTest.java
 * @Package com.test
 * @Copyright: 2018 All rights reserved.
 */
package com.test;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

/**
 * @ClassName: DelayQueueTest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年3月21日 下午5:27:03
 */
public class DelayQueueTest {

	/**
	 * 一个使用优先级队列实现的无界阻塞队列 @Title: main @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param: @param args @return: void @throws
	 */
	public static void main(String[] args) throws Exception {
		Object obj = new Object();
		DelayQueue<Delayed> dq = new DelayQueue();
		dq.add((Delayed) obj);
		dq.put((Delayed) obj);
	}

}
