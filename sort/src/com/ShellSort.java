/**
 * 
 */
package com;

/**
 * <p>
 * 标题：sort
 * </p>
 * <p>
 * 描述：ShellSort
 * </p>
 * <p>
 * 编译者：wuting
 * </p>
 * <p>
 * 版本：1.0
 * </p>
 * <p>
 * 文件名：com.ShellSort.java
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
 * 创建时间：2016年11月25日下午1:56:04
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
 * 修改时间：2016年11月25日下午1:56:04
 * </p>
 * <p>
 * 修改内容：
 * </p>
 */
public class ShellSort {

	private static long startTime;

	private static long endTime;

	/**
	 * 基本思想：算法先将要排序的一组数按某个增量d（n/2,n为要排序数的个数）分成若干组，每组中记录的下标相差
	 * d.对每组中全部元素进行直接插入排序，然后再用一个较小的增量（d/2）对它进行分组，在每组中再进行直接插入排序。当增量减到1时，进行直接
	 * 插入排序后，排序完成。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 12, 1, 3, 32, 21, 55, 35, 99, 88, 78, 75 };
		startTime = System.nanoTime();
		shellSort1(array);
		endTime = System.nanoTime();
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("希尔排序算法运行时间： " + (endTime - startTime) + "ns");
	}

	public static void shellSort(int[] array) {
		int n = array.length;
		int h;
		for (h = n / 2; h > 0; h /= 2) {
			System.out.println("第一次" + h);
			for (int i = h; i < n; i++) {
				System.out.println("第二次" + i + " " + n);
				for (int j = i - h; j >= 0; j -= h) {
					System.out.println("第三次" + j + " " + i + " " + h);
					if (array[j] > array[j + h]) {
						int temp = array[j];
						array[j] = array[j + h];
						array[j + h] = temp;
					}
				}
			}
		}
	}

	public static void shellSort1(int[] array) {
		int n = array.length;
		int h;
		// 每组中记录的下标相差h,直接插入排序中相差1
		for (h = n / 2; h > 0; h /= 2) {
			for (int i = h; i < n; i++) {
				for (int j = i - h; j >= 0; j -= h) {
					if (array[j] > array[j + 1]) {
						int temp = array[j];
						array[j] = array[j + 1];
						array[j + 1] = temp;
					}
				}
			}
		}
	}

}