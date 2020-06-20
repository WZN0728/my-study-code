/**
 * 
 */
package com;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * ���⣺sort
 * </p>
 * <p>
 * ������Demo
 * </p>
 * <p>
 * �����ߣ�wuting
 * </p>
 * <p>
 * �汾��1.0
 * </p>
 * <p>
 * �ļ�����com.Demo.java
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
 * ����ʱ�䣺2017��6��12������4:15:43
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
 * �޸�ʱ�䣺2017��6��12������4:15:43
 * </p>
 * <p>
 * �޸����ݣ�
 * </p>
 */
public class Demo {

	public static void main(String[] args) {
		System.out.println("3�Ľ׳�Ϊ��" + factorial(3));
		System.out.println("쳲��������еݹ��㷨��" + fubDigui(6));
		System.out.println("쳲���������ѭ���㷨��" + fubBL(6));
		System.out.println("쳲��������������㷨��" + fubArray(6));
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 91, 102, 208 };
		System.out.println("���ֲ��ҷ��ݹ���ң�" + searchRecursive(array, 6, 0, array.length));
		System.out.println("���ֲ��ҷ�ѭ�����ң�" + searchLoop(array, 6));
		String str = "asdfasfdasfasdf213123adfasdf234123adadsfasfd";
		System.out.println("��ȡ�ַ����е����֣�" + getNumStr(str));
		System.out.println("��ȡ�ַ����еĴ�Сд��ĸ��" + getStr(str));
		System.out.print("����������Ϊ��");
		bubbleSort(array);
		for (int i = 0, len = array.length; i < len; i++) {
			System.out.print(array[i] + "  ");
		}
		System.out.println();
		System.out.print("����������Ϊ��");
		bubbleSortYh(array);
		for (int i = 0, len = array.length; i < len; i++) {
			System.out.print(array[i] + "  ");
		}
		System.out.println();
		System.out.print("����������Ϊ��");
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
	 * 1��1��2��3��5��8��13��21......... F(1)=1,F(2)=1 if(n>2) F(N)=F(N-1)+F(N-2)
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
	 * �ݹ���ֲ��ҷ�
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
	 * ѭ�����ֲ��ҷ�
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
	 * ð���㷨��δ�Ż���
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
	 * ð���㷨���Ż���
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
	 * ѡ������
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
	 * ��ȡ�ַ���������
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
	 * ��ȡ�ַ����д�Сд��ĸ
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