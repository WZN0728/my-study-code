/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  ExchangerTest.java
 * @Package com.thread
 * @Copyright: 2018 All rights reserved.
 */
package com.thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: ExchangerTest
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��3��7�� ����11:13:41
 */
public class ExchangerTest {

	private static final Exchanger<String> exgr = new Exchanger<String>();

	private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

	/**
	 * Exchanger�������ߣ���һ�������̼߳�Э���Ĺ����ࡣExchanger���ڽ����̼߳�����ݽ�
	 * �������ṩһ��ͬ���㣬�����ͬ���㣬�����߳̿��Խ����˴˵����ݡ��������߳�ͨ��
	 * exchange�����������ݣ������һ���߳���ִ��exchange()����������һֱ�ȴ��ڶ����߳�Ҳ
	 * ִ��exchange�������������̶߳�����ͬ����ʱ���������߳̾Ϳ��Խ������ݣ������߳����� ���������ݴ��ݸ��Է��� @Title:
	 * main @Description: TODO(������һ�仰�����������������) @param: @param args @return:
	 * void @throws
	 */
	public static void main(String[] args) {
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				try {
					String A = "������ˮA";// A¼��������ˮ����
					exgr.exchange(A);
				} catch (InterruptedException e) {
				}
			}
		});
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				try {
					String B = "������ˮB";// B¼��������ˮ����
					String A = exgr.exchange("B");
					System.out.println("A��B�����Ƿ�һ�£�" + A.equals(B) + "��A¼����ǣ�" + A + "��B¼���ǣ�" + B);
				} catch (InterruptedException e) {
				}
			}
		});
		threadPool.shutdown();
	}

}
