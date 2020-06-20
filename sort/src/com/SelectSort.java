/**
 * 
 */
package com;

/**
 * <p>
 * ���⣺sort
 * </p>
 * <p>
 * ������SelectSort
 * </p>
 * <p>
 * �����ߣ�wuting
 * </p>
 * <p>
 * �汾��1.0
 * </p>
 * <p>
 * �ļ�����com.SelectSort.java
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
 * ����ʱ�䣺2016��12��14������3:54:45
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
 * �޸�ʱ�䣺2016��12��14������3:54:45
 * </p>
 * <p>
 * �޸����ݣ�
 * </p>
 */
public class SelectSort {

	private static long startTime;

	private static long endTime;

	/**
	 * ����˼�룺 1.��һ��ѭ����������ѡ��һ����С�������һ�������� 2.�ڶ���ѭ�����������ҳ���С������ڶ��������н���
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 12, 3, 1, 32, 21, 55, 35, 99, 88, 78, 75 };
		startTime = System.nanoTime();
		selectSortArrangement(array);
		endTime = System.nanoTime();
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("ѡ�������㷨����ʱ�䣺 " + (endTime - startTime) + "ns");
	}

	public static void selectSort(int[] array) {
		int len = array.length;
		for (int i = 0; i < len; i++) {
			int minIndex = i;
			for (int j = i + 1; j < len; j++) {
				if (array[minIndex] > array[j]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				int temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}
	}

	public static void selectSortArrangement(int[] a) {
		int n = a.length;
		for (int k = 0; k < n - 1; k++) {
			int min = k;
			for (int i = k + 1; i < n; i++)
				if (a[i] < a[min])
					min = i;
			if (k != min) {
				int temp = a[k];
				a[k] = a[min];
				a[min] = temp;
			} // end of if
		} // end of for
	}

}