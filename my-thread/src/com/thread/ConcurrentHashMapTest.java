/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  ConcurrentHashMapTest.java
 * @Package com.thread
 * @Copyright: 2018 All rights reserved.
 */
package com.thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: ConcurrentHashMapTest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年3月9日 下午10:30:41
 */
public class ConcurrentHashMapTest {

	static Map<Object, Object> chm = new ConcurrentHashMap<Object, Object>();

	/**
	 * ConcurrentHashMap是由Segment数组结构和HashEntry数组结构组成。Segment是一种可重
	 * 入锁（ReentrantLock），在ConcurrentHashMap里扮演锁的角色；HashEntry则用于存储键值对数
	 * 据。一个ConcurrentHashMap里包含一个Segment数组。Segment的结构和HashMap类似，是一种
	 * 数组和链表结构。一个Segment里包含一个HashEntry数组，每个HashEntry是一个链表结构的元
	 * 素，每个Segment守护着一个HashEntry数组里的元素，当对HashEntry数组的数据进行修改时， 必须首先获得与它对应的Segment锁
	 */
	public static void main(String[] args) throws Exception {
		ExecutorService service = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			/*service.execute(()->{
				for (int j = 0; j < 100; j++) {
					chm.put(j, Thread.currentThread() + "---执行--->" + j);
				}
			});*/
			service.execute(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 100; j++) {
						chm.put(j, Thread.currentThread() + "---执行--->" + j);
					}
				}
			});
		}
		service.shutdown();
		service.awaitTermination(1, TimeUnit.DAYS);
		for (Map.Entry entry : chm.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

}
