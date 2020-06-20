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
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��3��9�� ����10:30:41
 */
public class ConcurrentHashMapTest {

	static Map<Object, Object> chm = new ConcurrentHashMap<Object, Object>();

	/**
	 * ConcurrentHashMap����Segment����ṹ��HashEntry����ṹ��ɡ�Segment��һ�ֿ���
	 * ������ReentrantLock������ConcurrentHashMap��������Ľ�ɫ��HashEntry�����ڴ洢��ֵ����
	 * �ݡ�һ��ConcurrentHashMap�����һ��Segment���顣Segment�Ľṹ��HashMap���ƣ���һ��
	 * ���������ṹ��һ��Segment�����һ��HashEntry���飬ÿ��HashEntry��һ������ṹ��Ԫ
	 * �أ�ÿ��Segment�ػ���һ��HashEntry�������Ԫ�أ�����HashEntry��������ݽ����޸�ʱ�� �������Ȼ��������Ӧ��Segment��
	 */
	public static void main(String[] args) throws Exception {
		ExecutorService service = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			/*service.execute(()->{
				for (int j = 0; j < 100; j++) {
					chm.put(j, Thread.currentThread() + "---ִ��--->" + j);
				}
			});*/
			service.execute(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 100; j++) {
						chm.put(j, Thread.currentThread() + "---ִ��--->" + j);
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
