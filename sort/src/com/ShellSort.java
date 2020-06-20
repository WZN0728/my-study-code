/**
 * 
 */
package com;

/**
 * <p>
 * ���⣺sort
 * </p>
 * <p>
 * ������ShellSort
 * </p>
 * <p>
 * �����ߣ�wuting
 * </p>
 * <p>
 * �汾��1.0
 * </p>
 * <p>
 * �ļ�����com.ShellSort.java
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
 * ����ʱ�䣺2016��11��25������1:56:04
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
 * �޸�ʱ�䣺2016��11��25������1:56:04
 * </p>
 * <p>
 * �޸����ݣ�
 * </p>
 */
public class ShellSort {

	private static long startTime;

	private static long endTime;

	/**
	 * ����˼�룺�㷨�Ƚ�Ҫ�����һ������ĳ������d��n/2,nΪҪ�������ĸ������ֳ������飬ÿ���м�¼���±����
	 * d.��ÿ����ȫ��Ԫ�ؽ���ֱ�Ӳ�������Ȼ������һ����С��������d/2���������з��飬��ÿ�����ٽ���ֱ�Ӳ������򡣵���������1ʱ������ֱ��
	 * ���������������ɡ�
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
		System.out.println("ϣ�������㷨����ʱ�䣺 " + (endTime - startTime) + "ns");
	}

	public static void shellSort(int[] array) {
		int n = array.length;
		int h;
		for (h = n / 2; h > 0; h /= 2) {
			System.out.println("��һ��" + h);
			for (int i = h; i < n; i++) {
				System.out.println("�ڶ���" + i + " " + n);
				for (int j = i - h; j >= 0; j -= h) {
					System.out.println("������" + j + " " + i + " " + h);
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
		// ÿ���м�¼���±����h,ֱ�Ӳ������������1
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