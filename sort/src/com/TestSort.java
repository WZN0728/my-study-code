/**
 * 
 */
package com;

/**
 * <p>
 * ���⣺sort
 * </p>
 * <p>
 * ������TestSort
 * </p>
 * <p>
 * �����ߣ�wuting
 * </p>
 * <p>
 * �汾��1.0
 * </p>
 * <p>
 * �ļ�����com.TestSort.java
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
 * ����ʱ�䣺2016��12��9������3:04:31
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
 * �޸�ʱ�䣺2016��12��9������3:04:31
 * </p>
 * <p>
 * �޸����ݣ�
 * </p>
 */
public class TestSort {

	private static long startTime;

	private static long endTime;

	public static void main(String[] args) {
		int[] array = { 12, 1, 3, 32, 21, 55, 35, 99, 88, 78, 75 };
		startTime = System.nanoTime();
		// bubbleSort(array);
		// bubbleSortOptimization(array);
		// quickSort(array, 0, array.length - 1);
		// insertSort(array);
		selectSort(array);
		endTime = System.nanoTime();
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("�㷨����ʱ�䣺 " + (endTime - startTime) + "ns");
	}

	// ð���㷨
	public static void bubbleSort(int[] array) {
		for (int i = 0, len = array.length; i < len; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	// ð���㷨�Ż�
	public static void bubbleSortOptimization(int[] array) {
		boolean flag = true;
		int len = array.length;
		while (flag) {
			flag = false;
			for (int i = 0; i < len - 1; i++) {
				if (array[i] > array[i + 1]) {
					int temp = array[i + 1];
					array[i + 1] = array[i];
					array[i] = temp;
				}
				flag = true;
			}
			len--;
		}
	}

	// ��������,ð���㷨�Ľ�
	public static void quickSort(int[] array, int left, int right) {
		if (left < right) {
			int low = left;
			int high = right;
			int middle = array[low];
			while (low < high) {
				while (low < high && array[high] >= middle) {
					high--;
				}
				array[low] = array[high];
				while (low < high && array[low] <= middle) {
					low++;
				}
				array[high] = array[low];
			}
			array[low] = middle;
			quickSort(array, left, low - 1);
			quickSort(array, low + 1, right);
		}
	}

	// ��������
	public static void insertSort(int[] array) {
		for (int i = 1, len = array.length; i < len; i++) {
			if (array[i] < array[i - 1]) {
				int temp = array[i];
				int j;
				for (j = i - 1; j >= 0 && temp < array[j]; j--) {
					array[j + 1] = array[j];
				}
				array[j + 1] = temp;
			}
		}
	}

	// ѡ������
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

}