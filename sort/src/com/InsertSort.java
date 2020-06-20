/**
 * 
 */
package com;

/**
 * <p>
 * 标题：sort
 * </p>
 * <p>
 * 描述：InsertSort
 * </p>
 * <p>
 * 编译者：wuting
 * </p>
 * <p>
 * 版本：1.0
 * </p>
 * <p>
 * 文件名：com.InsertSort.java
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
 * 创建时间：2016年11月24日上午11:25:07
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
 * 修改时间：2016年11月24日上午11:25:07
 * </p>
 * <p>
 * 修改内容：
 * </p>
 */
public class InsertSort {

	private static long startTime;

	private static long endTime;

	/**
	 * 在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排 好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数
	 * 也是排好顺序的。如此反复循环，直到全部排好顺序。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 12, 1, 3, 32, 21, 55, 35, 99, 88, 78, 75 };
		startTime = System.nanoTime();
		insertSort1(array);
		endTime = System.nanoTime();
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("直接插入排序算法运行时间： " + (endTime - startTime) + "ns");
	}

	public static void insertSort(int[] array) {
		// for(int i=0;i<array.length;i++)多次赋值运算；for (int i = 1, len =
		// array.length; i < len; i++)一次赋值运算
		for (int i = 1, len = array.length; i < len; i++) {
			if (array[i] < array[i - 1]) {
				int temp = array[i];
				int j;
				// 将大于temp 的值整体后移一个单位
				// temp<arra[j]相当于array[i]<array[j]
				for (j = i - 1; j >= 0 && temp < array[j]; j--) {
					array[j + 1] = array[j];
				}
				array[j + 1] = temp;
			}
		}
	}

	public static void insertSort1(int[] array) {
		for (int i = 1, len = array.length; i < len; i++) {
			if (array[i - 1] > array[i]) {
				int temp = array[i];
				int j;
				for (j = i - 1; j >= 0 && temp < array[j]; j--) {
					array[j + 1] = array[j];
				}
				array[j + 1] = temp;
			}
		}
	}

}