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
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��3��19�� ����6:09:37
 */
public class ArrayBlockingQueueTest {

	/**
	 * ArrayBlockingQueue����һ����������ṹ���н��������У��˶��а�FIFO���Ƚ��ȳ���ԭ ���Ԫ�ؽ������� @Title:
	 * main @Description: TODO(������һ�仰�����������������) @param: @param args @param: @throws
	 * Exception @return: void @throws
	 */
	public static void main(String[] args) throws Exception {
		Object obj = new Object();
		//���Ƴ�ʼ���췽���ĳ�ʼֵ�����ҿ���ѡ���ǹ�ƽ�����Ƿǹ�ƽ��
		ArrayBlockingQueue abq = new ArrayBlockingQueue(100, true);
		abq.put(obj);
	}

}
