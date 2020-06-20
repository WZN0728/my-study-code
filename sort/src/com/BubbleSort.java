/**
 *
 */
package com;

import java.util.Arrays;

/**
 * <p>
 * ���⣺sort
 * </p>
 * <p>
 * ������SortArray
 * </p>
 * <p>
 * �����ߣ�wuting
 * </p>
 * <p>
 * �汾��1.0
 * </p>
 * <p>
 * �ļ�����com.SortArray.java
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
 * ����ʱ�䣺2016��11��22������2:24:40
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
 * �޸�ʱ�䣺2016��11��22������2:24:40
 * </p>
 * <p>
 * �޸����ݣ�
 * </p>
 */
//ð�����������Ż�
public class BubbleSort {

    private static long startTime;

    private static long endTime;

    /**
     * 1.1 �㷨ԭ�� S1���Ӵ��������е���ʼλ�ÿ�ʼ����ǰ�������αȽϸ���λ�ú����һλ�õĴ�С��ִ��S2��
     * S2�������ǰλ�õ�ֵ�������һλ�õ�ֵ���Ͱ�������ֵ���������һ��ȫ���бȽϺ��������λ�õ�ֵ�����������ֵ�������䲻��Ҫ�ٲ���ð�ݣ���
     * S3�������е����λ�ôӴ������������Ƴ������Ƴ���Ĵ��������в�Ϊ�������ִ��S1������ð�ݽ�����
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {12, 1, 3, 32, 21, 55, 35, 99, 88, 78, 75};
        startTime = System.nanoTime();
        bubbleSort(array);
        endTime = System.nanoTime();
        System.out.println(Arrays.toString(array));
        System.out.println("δ�Ż���ð���㷨����ʱ�䣺 " + (endTime - startTime) + "ns");
        int[] array1 = {12, 1, 3, 32, 21, 55, 35, 99, 88, 78, 75};
        startTime = System.nanoTime();
        bubbleSortOptimization(array1);
        endTime = System.nanoTime();
        System.out.println(Arrays.toString(array1));
        System.out.println("�Ż���ð���㷨����ʱ�䣺 " + (endTime - startTime) + "ns");
        int[] array2 = {12, 1, 3, 32, 21, 55, 35, 99, 88, 78, 75};
        startTime = System.nanoTime();
        bubbleSortOptimization2(array2);
        endTime = System.nanoTime();
        System.out.println(Arrays.toString(array2));
        System.out.println("�ٴ��Ż���ð���㷨����ʱ�䣺 " + (endTime - startTime) + "ns");
    }

    // ð���㷨,δ�Ż�
    public static void bubbleSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    // �Ż����ð���㷨(��ĳһ��������δ����һ�ν��������������)
    public static void bubbleSortOptimization(int[] array) {
        int len = array.length;
        boolean flag = true;
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

    public static void bubbleSortOptimization2(int[] array) {
        int temp = 0;
        int len = array.length;
        //��¼���һ�ν�����λ��
        int lastChangeIndex = 0;
        //�������еı߽磬ÿ�αȽ�ֻ��Ҫ�ȵ�����Ϊֹ
        int sortPosition = array.length - 1;
        for (int i = 0; i < len; i++) {
            //�����ǣ�ÿһ�ֵĳ�ʼ��true
            boolean flag = true;
            for (int j = 0; j < sortPosition; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    //���������еı߽����Ϊ���һ�ν���Ԫ�ص�λ��
                    lastChangeIndex = j;
                    //��Ԫ�ؽ��������Բ������򣬱�Ǳ�Ϊfalse
                    flag = false;
                }
            }
            sortPosition = lastChangeIndex;
            if (flag) {
                break;
            }
        }
    }

}