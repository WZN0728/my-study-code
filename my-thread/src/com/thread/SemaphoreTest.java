/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  SemaphoreTest.java
 * @Package com.thread
 * @Copyright: 2018 All rights reserved.
 */
package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName: SemaphoreTest
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��3��7�� ����11:04:58
 */
public class SemaphoreTest {

	private static final int THREAD_COUNT = 30;

	private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

	private static Semaphore s = new Semaphore(10);

	/**
	 * Semaphore���ź���������������ͬʱ�����ض���Դ���߳���������ͨ��Э�������̣߳��� ��֤�����ʹ�ù�����Դ��
	 * �����������Ҷ����ô������Ϻ������Semaphore�����ĺ��壬ֻ�ܰ��������ǿ�����
	 * ���ĺ��̵ơ����������·Ҫ����������ֻ����ͬʱ��һ������������·����ʹ�������Ķ�����
	 * ��·�ڵȴ�������ǰһ�������ῴ���̵ƣ����Կ���������·������ĳ��ῴ����ƣ�����ʻ
	 * �������·���������ǰһ��������5�����Ѿ��뿪�ˡ�����·����ô�����������5����ʻ����
	 * ·�����������˵�ĳ������̣߳�ʻ����·�ͱ�ʾ�߳���ִ�У��뿪��·�ͱ�ʾ�߳�ִ���� �ɣ�������ƾͱ�ʾ�̱߳�����������ִ�С� @Title:
	 * main @Description: TODO(������һ�仰�����������������) @param: @param args @return:
	 * void @throws
	 */
	public static void main(String[] args) {
		for (int i = 0; i < THREAD_COUNT; i++) {
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						//Semaphore��acquire()������ȡһ�����֤
						s.acquire();
						System.out.println("save data");
						//ʹ����֮�����release()�����黹���֤,��������tryAcquire()�������Ի�ȡ���֤��
						s.release();
					} catch (InterruptedException e) {
					}
				}
			});
		}
		threadPool.shutdown();
	}

}
