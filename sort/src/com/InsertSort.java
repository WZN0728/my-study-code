/**
 * 
 */
package com;

/**
 * <p>
 * ���⣺sort
 * </p>
 * <p>
 * ������InsertSort
 * </p>
 * <p>
 * �����ߣ�wuting
 * </p>
 * <p>
 * �汾��1.0
 * </p>
 * <p>
 * �ļ�����com.InsertSort.java
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
 * ����ʱ�䣺2016��11��24������11:25:07
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
 * �޸�ʱ�䣺2016��11��24������11:25:07
 * </p>
 * <p>
 * �޸����ݣ�
 * </p>
 */
public class InsertSort {

	private static long startTime;

	private static long endTime;

	/**
	 * ��Ҫ�����һ�����У�����ǰ��(n-1)[n>=2] �����Ѿ����� ��˳��ģ�����Ҫ�ѵ�n�����嵽ǰ����������У�ʹ����n����
	 * Ҳ���ź�˳��ġ���˷���ѭ����ֱ��ȫ���ź�˳��
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
		System.out.println("ֱ�Ӳ��������㷨����ʱ�䣺 " + (endTime - startTime) + "ns");
	}

	public static void insertSort(int[] array) {
		// for(int i=0;i<array.length;i++)��θ�ֵ���㣻for (int i = 1, len =
		// array.length; i < len; i++)һ�θ�ֵ����
		for (int i = 1, len = array.length; i < len; i++) {
			if (array[i] < array[i - 1]) {
				int temp = array[i];
				int j;
				// ������temp ��ֵ�������һ����λ
				// temp<arra[j]�൱��array[i]<array[j]
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