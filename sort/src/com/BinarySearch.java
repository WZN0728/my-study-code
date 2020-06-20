/**
 * 
 */
package com;

/**
 * <p>
 * ���⣺sort
 * </p>
 * <p>
 * ������BinarySearch
 * </p>
 * <p>
 * �����ߣ�wuting
 * </p>
 * <p>
 * �汾��1.0
 * </p>
 * <p>
 * �ļ�����com.BinarySearch.java
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
 * ����ʱ�䣺2016��12��15������1:37:01
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
 * �޸�ʱ�䣺2016��12��15������1:37:01
 * </p>
 * <p>
 * �޸����ݣ�
 * </p>
 */
public class BinarySearch {

	private static long startTime;

	private static long endTime;

	/**
	 * ����˼�룺����һ���м�ֵ,�Ե�ǰ����ĳ��ȳ���2����,�����м�ֵ������ǰ�������Ĳ���
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 1, 3, 12, 21, 32, 35, 55, 75, 78, 88, 99 };
		startTime = System.nanoTime();
		System.out.println(searchRecursive(array, 12, 0, array.length - 1));
		endTime = System.nanoTime();
		System.out.println("���ֲ��ҷ��ݹ����ִ��ʱ��Ϊ��" + (endTime - startTime) + "ns");
		startTime = System.nanoTime();
		System.out.println(searchLoop(array, 12));
		endTime = System.nanoTime();
		System.out.println("���ֲ��ҷ�ѭ������ִ��ʱ��Ϊ��" + (endTime - startTime) + "ns");
	}

	public static int searchRecursive(int[] array, int findValue, int left, int right) {
		if (left <= right) {
			int middle = (left + right) / 2;
			int middleValue = array[middle];
			if (middleValue == findValue) {
				return middle;
			} else if (middleValue > findValue) {
				return searchRecursive(array, findValue, left, middle - 1);
			} else {
				return searchRecursive(array, findValue, middle + 1, right);
			}
		} else {
			return -1;
		}
	}

	public static int searchLoop(int[] array, int findValue) {
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int middle = (left + right) / 2;
			int middleValue = array[middle];
			if (middleValue == findValue) {
				return middle;
			} else if (middleValue > findValue) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		return -1;
	}

}