/**
 * 
 */
package com;

/**
 * <p>
 * ���⣺sort
 * </p>
 * <p>
 * ������Factorial
 * </p>
 * <p>
 * �����ߣ�wuting
 * </p>
 * <p>
 * �汾��1.0
 * </p>
 * <p>
 * �ļ�����com.Factorial.java
 * </p>
 * <p>
 * ��Ȩ��Copyright (c) 2002-2016 Digitalchina CO.,LTD. All rights reserved.
 * </p>
 * <p>
 * ��˾����������ϵͳ���ɷ������޹�˾
 * </p>
 * <p>
 * ���ߣ�wuting
 * </p>
 * <p>
 * ����ʱ�䣺2016��12��15������2:14:03
 * </p>
 * <p>
 * �����ˣ�wuting
 * </p>
 * <p>
 * ���ţ�����Ժ��ȫ�ɿ��з����Ĳ�Ʒ�з���
 * </p>
 * <p>
 * �޸��ߣ�wuting
 * </p>
 * <p>
 * �޸�ʱ�䣺2016��12��15������2:14:03
 * </p>
 * <p>
 * �޸����ݣ�
 * </p>
 */
public class Factorial {

	private static long startTime;

	private static long endTime;

	/**
	 * �ݹ���׳�m*factorial(m-1)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		startTime = System.nanoTime();
		System.out.println(factorial(7));
		endTime = System.nanoTime();
		System.out.println("�ݹ���׳˵�ִ��ʱ��Ϊ��" + (endTime - startTime) + "ns");
	}

	public static int factorial(int n) {
		if (n == 0 || n == 1 | n == 2) {
			return n;
		} else {
			return n * factorial(n - 1);
		}
	}

}