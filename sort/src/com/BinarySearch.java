/**
 * 
 */
package com;

/**
 * <p>
 * 标题：sort
 * </p>
 * <p>
 * 描述：BinarySearch
 * </p>
 * <p>
 * 编译者：wuting
 * </p>
 * <p>
 * 版本：1.0
 * </p>
 * <p>
 * 文件名：com.BinarySearch.java
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
 * 创建时间：2016年12月15日下午1:37:01
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
 * 修改时间：2016年12月15日下午1:37:01
 * </p>
 * <p>
 * 修改内容：
 * </p>
 */
public class BinarySearch {

	private static long startTime;

	private static long endTime;

	/**
	 * 基本思想：定义一个中间值,以当前数组的长度除以2定义,根据中间值进行向前或者向后的查找
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 1, 3, 12, 21, 32, 35, 55, 75, 78, 88, 99 };
		startTime = System.nanoTime();
		System.out.println(searchRecursive(array, 12, 0, array.length - 1));
		endTime = System.nanoTime();
		System.out.println("二分查找法递归查找执行时间为：" + (endTime - startTime) + "ns");
		startTime = System.nanoTime();
		System.out.println(searchLoop(array, 12));
		endTime = System.nanoTime();
		System.out.println("二分查找法循环查找执行时间为：" + (endTime - startTime) + "ns");
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