/**
 * 
 */
package com;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 标题：sort
 * </p>
 * <p>
 * 描述：Demo
 * </p>
 * <p>
 * 编译者：wuting
 * </p>
 * <p>
 * 版本：1.0
 * </p>
 * <p>
 * 文件名：com.Demo.java
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
 * 创建时间：2017年6月12日下午4:15:43
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
 * 修改时间：2017年6月12日下午4:15:43
 * </p>
 * <p>
 * 修改内容：
 * </p>
 */
public class Demo {

	public static void main(String[] args) {
		System.out.println("3的阶乘为：" + factorial(3));
		System.out.println("斐波那契数列递归算法：" + fubDigui(6));
		System.out.println("斐波那契数列循环算法：" + fubBL(6));
		System.out.println("斐波那契数列数组算法：" + fubArray(6));
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 91, 102, 208 };
		System.out.println("二分查找法递归查找：" + searchRecursive(array, 6, 0, array.length));
		System.out.println("二分查找法循环查找：" + searchLoop(array, 6));
		String str = "asdfasfdasfasdf213123adfasdf234123adadsfasfd";
		System.out.println("获取字符串中的数字：" + getNumStr(str));
		System.out.println("获取字符串中的大小写字母：" + getStr(str));
		System.out.print("排序后的数组为：");
		bubbleSort(array);
		for (int i = 0, len = array.length; i < len; i++) {
			System.out.print(array[i] + "  ");
		}
		System.out.println();
		System.out.print("排序后的数组为：");
		bubbleSortYh(array);
		for (int i = 0, len = array.length; i < len; i++) {
			System.out.print(array[i] + "  ");
		}
		System.out.println();
		System.out.print("排序后的数组为：");
		selectSort(array);
		for (int i = 0, len = array.length; i < len; i++) {
			System.out.print(array[i] + "  ");
		}
	}

	public static int factorial(int n) {
		if (n == 0 || n == 1 || n == 2) {
			return n;
		} else {
			return n * factorial(n - 1);
		}
	}

	/**
	 * 1、1、2、3、5、8、13、21......... F(1)=1,F(2)=1 if(n>2) F(N)=F(N-1)+F(N-2)
	 * 
	 * @param n
	 * @return
	 */
	public static int fubDigui(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return fubDigui(n - 1) + fubDigui(n - 2);
		}
	}

	public static int fubBL(int n) {
		int a = 1, b = 1, c = 0;
		for (int i = 0; i < n - 2; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}

	public static int fubArray(int n) {
		int[] array = new int[n];
		array[0] = array[1] = 1;
		for (int i = 2; i < array.length; i++) {
			array[i] = array[i - 1] + array[i - 2];
		}
		return array[n - 1];
	}

	/**
	 * 递归二分查找法
	 * 
	 * @return
	 */
	public static int searchRecursive(int[] array, int findValue, int left, int right) {
		int middle = (left + right) / 2;
		if (left <= right) {
			if (array[middle] == findValue) {
				return findValue;
			} else if (array[middle] > findValue) {
				return searchRecursive(array, findValue, left, middle - 1);
			} else {
				return searchRecursive(array, findValue, middle + 1, right);
			}
		} else {
			return -1;
		}
	}

	/**
	 * 循环二分查找法
	 * 
	 * @param array
	 * @param findValue
	 * @return
	 */
	public static int searchLoop(int[] array, int findValue) {
		int left = 0;
		int right = array.length;
		while (left <= right) {
			int middle = (left + right) / 2;
			int middleValue = array[middle];
			if (middleValue == findValue) {
				return findValue;
			} else if (middleValue < findValue) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return -1;
	}

	/**
	 * 冒泡算法（未优化）
	 * 
	 * @param array
	 */
	public static void bubbleSort(int[] array) {
		int len = array.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * 冒泡算法（优化）
	 * 
	 * @param array
	 */
	public static void bubbleSortYh(int[] array) {
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

	/**
	 * 选择排序
	 * 
	 * @param array
	 */
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

	/**
	 * 获取字符串中数字
	 * 
	 * @param value
	 * @return
	 */
	public static String getNumStr(String value) {
		Pattern p = Pattern.compile("[^0-9]");
		Matcher m = p.matcher(value);
		return m.replaceAll("");
	}

	/**
	 * 获取字符串中大小写字母
	 * 
	 * @param value
	 * @return
	 */
	public static String getStr(String value) {
		Pattern p = Pattern.compile("[^a-zA-Z]");
		Matcher m = p.matcher(value);
		return m.replaceAll("");
	}

	public String getArraysToString(){
		int[] i = {1,2,23};
		String s = Arrays.toString(i);
		return s;
	}

}