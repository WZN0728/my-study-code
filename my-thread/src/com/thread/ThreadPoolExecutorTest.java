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
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��4��11�� ����2:43:50
 */
public class ThreadPoolExecutorTest extends ThreadPoolExecutor{

	/**
	 * corePoolSize, �����߳���
	 * maximumPoolSize, �����߳���
	 * keepAliveTime, ����Ĵ��ʱ�䣬Ҳ���Ǹ�ֵ
	 * unit, TimeUnit�����ͣ���/Сʱ/����/����
	 * workQueue, �ȴ����У���corePoolSize����ʱ�����뵱ǰ�ĵȴ�����
	 * threadFactory, ���嵱ǰ���̵߳����֣������ڳ����쳣ʱ�Ļ���
	 * handler, �Զ���ľ���¼��������ǰ�ĺ����̣߳��ȴ����У��Ѿ��Ǻ����̶߳����ˣ���ô�����Զ��履�Ͳ��ԣ����Խ���ǰ�������̴߳��뵽һ�����л��߳־û������ݿ⣬�Ա㽫���ó�����ִ��
	 * @Title: main
	 * @Description: TODO(������һ�仰�����������������)
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
	 *            �̳߳صĺ����߳���
	 * @param maximumPoolSize
	 *            �̳߳��е�����߳��������������߳�������������߳����е��߳�Ϊ�Ǻ����̣߳���ֵ������̵߳�ֵ������ͬ����û�зǺ����̣߳�
	 * @param keepAliveTime
	 *            ��ֵʱ�䣬����ݴ�ʱ�䶨������û��ִ������ĺ����̺߳ͷǺ����߳�
	 * @param unit
	 *            �趨��ֵʱ��ĵ�λ��ʱ���֡��룩
	 * @param blockingQueue
	 *            �ȴ�����
	 * @param threadName
	 *            �߳����������߳����Ʒ��������ʱ���ݣ�
	 */
	public ThreadPoolExecutorTest(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			int blockingQueue, final String threadName) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, new ArrayBlockingQueue<Runnable>(blockingQueue),
				new ThreadFactory() {
					@Override
					public Thread newThread(Runnable r) {
						// TODO Auto-generated method stub
						return new Thread(r, "�߳�����[" + threadName + "]:" + r.hashCode());
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
