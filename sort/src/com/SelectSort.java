/**
 * 
 */
package com;

/**
 * <p>
 * 标题：sort
 * </p>
 * <p>
 * 描述：SelectSort
 * </p>
 * <p>
 * 编译者：wuting
 * </p>
 * <p>
 * 版本：1.0
 * </p>
 * <p>
 * 文件名：com.SelectSort.java
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
 * 创建时间：2016年12月14日下午3:54:45
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
 * 修改时间：2016年12月14日下午3:54:45
 * </p>
 * <p>
 * 修改内容：
 * </p>
 */
public class SelectSort {

	private static long startTime;

	private static long endTime;

	/**
	 * 基本思想： 1.第一次循环在数组中选择一个最小的数与第一个数交换 2.第二次循环从数组中找出最小的数与第二个数进行交换
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
		System.out.println("选择排序算法运行时间： " + (endTime - startTime) + "ns");
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