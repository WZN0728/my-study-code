/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  LinkedBlockingDequeTest.java
 * @Package com.test
 * @Copyright: 2018 All rights reserved.
 */
package com.test;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * һ��������ṹ��ɵ�˫����������
 * 
 * @ClassName: LinkedBlockingDequeTest
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��3��21�� ����5:29:09
 */
public class LinkedBlockingDequeTest {

	/**
	 * һ��������ṹ��ɵ�˫����������,LinkedBlockingDeque��һ��������ṹ��ɵ�˫���������С���ν˫�����ָ���ǿ���
	 * �Ӷ��е����˲�����Ƴ�Ԫ�ء�˫�������Ϊ����һ���������е���ڣ��ڶ��߳�ͬʱ���
	 * ʱ��Ҳ�ͼ�����һ��ľ���������������������У�LinkedBlockingDeque����addFirst��
	 * addLast��offerFirst��offerLast��peekFirst��peekLast�ȷ�������First���ʽ�β�ķ�������ʾ���롢
	 * ��ȡ��peek�����Ƴ�˫�˶��еĵ�һ��Ԫ�ء���Last���ʽ�β�ķ�������ʾ���롢��ȡ���Ƴ�˫
	 * �˶��е����һ��Ԫ�ء����⣬���뷽��add��ͬ��addLast���Ƴ�����remove��Ч��
	 * removeFirst������take����ȴ��ͬ��takeFirst����֪���ǲ���JDK��bug��ʹ��ʱ�����ô���First
	 * ��Last��׺�ķ�������� @Title: main @Description: TODO(������һ�仰�����������������) @param: @param
	 * args @param: @throws Exception @return: void @throws
	 */
	public static void main(String[] args) throws Exception {
		Object obj = new Object();
		LinkedBlockingDeque lbd = new LinkedBlockingDeque();
		lbd.add(obj);
		lbd.put(obj);
	}

}
