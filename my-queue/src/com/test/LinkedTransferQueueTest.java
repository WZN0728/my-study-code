/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  LinkedTransferQueueTest.java
 * @Package com.test
 * @Copyright: 2018 All rights reserved.
 */
package com.test;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @ClassName: LinkedTransferQueueTest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年3月21日 下午5:28:13
 */
public class LinkedTransferQueueTest {

	/**
	 * 一个由链表结构组成的无界阻塞队列 @Title: main @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param: @param args @return: void @throws
	 */
	public static void main(String[] args) throws Exception {
		Object obj = new Object();
		LinkedTransferQueue ltq = new LinkedTransferQueue();
		ltq.add(obj);
		ltq.put(obj);
	}

}
