/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  ArrayBlockingQueueTest.java
 * @Package com.test
 * @Copyright: 2018 All rights reserved.
 */
package com.test;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ClassName: ArrayBlockingQueueTest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年3月19日 下午6:09:37
 */
public class ArrayBlockingQueueTest {

	/**
	 * ArrayBlockingQueue：是一个基于数组结构的有界阻塞队列，此队列按FIFO（先进先出）原 则对元素进行排序 @Title:
	 * main @Description: TODO(这里用一句话描述这个方法的作用) @param: @param args @param: @throws
	 * Exception @return: void @throws
	 */
	public static void main(String[] args) throws Exception {
		Object obj = new Object();
		//控制初始构造方法的初始值，并且可以选择是公平锁还是非公平锁
		ArrayBlockingQueue abq = new ArrayBlockingQueue(100, true);
		abq.put(obj);
	}

}
