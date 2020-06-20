/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  test.java
 * @Package com.thread
 * @Copyright: 2018 All rights reserved.
 */
package com.thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

/**
 * @ClassName: test
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��3��19�� ����2:46:03
 */
public class FairAndUnfairTest {
	private static Lock fairLock = new ReentrantLock2(true);
	private static Lock unfairLock = new ReentrantLock2(false);

	@Test
	public void fair() {
		testLock(fairLock);
	}

	@Test
	public void unfair() {
		testLock(unfairLock);
	}

	private void testLock(Lock lock) {
		Job job = new Job(lock);
		// ����5��Job���ԣ�
		for (int i = 0; i < 5; i++) {
			job.start();
		}
	}

	private static class Job extends Thread {
		private Lock lock;

		public Job(Lock lock) {
			this.lock = lock;
		}

		public void run() {
			// ����2�δ�ӡ��ǰ��Thread�͵ȴ������е�Thread���ԣ�
			System.out.println("��ǰ�߳�:" + Thread.currentThread() + ",");
		}
	}

	private static class ReentrantLock2 extends ReentrantLock {
		public ReentrantLock2(boolean fair) {
			super(fair);
		}

		public Collection<Thread> getQueuedThreads() {
			List<Thread> arrayList = new ArrayList<Thread>(super.getQueuedThreads());
			Collections.reverse(arrayList);
			return arrayList;
		}
	}

}
