/**
 * 
 */
package com;

/**
 * <p>
 * 标题：sort
 * </p>
 * <p>
 * 描述：TestSort
 * </p>
 * <p>
 * 编译者：wuting
 * </p>
 * <p>
 * 版本：1.0
 * </p>
 * <p>
 * 文件名：com.TestSort.java
 * </p>
 * <p>
 * 版权：Copyright (c) 2002-2016 Digitalchina CO.,LTD. All rights reserved.
 * </p>
 * <p>
 * 公司：神州数码系统集成服务有限公司
 * </p>
 * <p>
 * 作者：wuting
 * </p>
 * <p>
 * 创建时间：2016年12月9日下午3:04:31
 * </p>
 * <p>
 * 负责人：wuting
 * </p>
 * <p>
 * 部门：工程院安全可靠研发中心产品研发部
 * </p>
 * <p>
 * 修改者：wuting
 * </p>
 * <p>
 * 修改时间：2016年12月9日下午3:04:31
 * </p>
 * <p>
 * 修改内容：
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
		System.out.println("算法运行时间： " + (endTime - startTime) + "ns");
	}

	// 冒泡算法
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

	// 冒泡算法优化
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

	// 快速排序,冒泡算法改进
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

	// 插入排序
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

	// 选择排序
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