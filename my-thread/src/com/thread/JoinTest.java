/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  JoinTest.java
 * @Package com.thread
 * @Copyright: 2018 All rights reserved.
 */
package com.thread;

/**
 * @ClassName: JoinTest
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��3��7�� ����10:15:13
 */
public class JoinTest {

	static Thread thread1 = new Thread(new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("thread1");
		}
	});

	static Thread thread2 = new Thread(new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("thread2");
		}
	});

	static Thread thread3 = new Thread(new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("thread3");
		}
	});

	/**
	 * join�����õ�ǰִ���̵߳ȴ�join�߳�ִ�н�������ʵ��ԭ���ǲ�ͣ���join�߳��Ƿ��
	 * ����join�̴߳�����õ�ǰ�߳���Զ�ȴ������У�wait��0����ʾ��Զ�ȴ���ȥ������Ƭ���� �¡� while (isAlive()) {
	 * wait(0); } ֱ��join�߳���ֹ���̵߳�this.notifyAll()�����ᱻ���ã�����notifyAll()��������JVM��
	 * ʵ�ֵģ�������JDK�￴��������ҿ��Բ鿴JVMԴ�롣
	 * ��JDK1.5֮��Ĳ��������ṩ��CountDownLatchҲ����ʵ��join�Ĺ��ܣ����ұ�join�Ĺ� �ܸ���
	 * {@link java.util.concurrent.CountDownLatch}
	 */
	public static void main(String[] args) throws Exception {
		thread1.start();
		thread1.join();
		thread2.start();
		thread2.join();
		thread3.start();
	}

}
