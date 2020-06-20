package com;

import java.util.Arrays;

/**
 * @author wuting
 * @date 2019/03/28
 */
//��β������
public class CockTailSort {

    private static long startTime;

    private static long endTime;

    /**
     * �������Ӱ��˶�,������,���ҵ���
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {12, 1, 3, 32, 21, 55, 35, 99, 88, 78, 75};
        startTime = System.nanoTime();
        sort1(array);
        endTime = System.nanoTime();
        System.out.print(Arrays.toString(array));
        System.out.println("��β���㷨����ʱ�䣺 " + (endTime - startTime) + "ns");
        int[] array1 = {12, 1, 3, 32, 21, 55, 35, 99, 88, 78, 75};
        startTime = System.nanoTime();
        sort2(array1);
        endTime = System.nanoTime();
        System.out.print(Arrays.toString(array1));
        System.out.println("�Ż��ļ�β���㷨����ʱ�䣺 " + (endTime - startTime) + "ns");
    }

    public static void sort1(int[] array) {
        int temp = 0;
        int len = array.length - 1;
        for (int i = 0; i < array.length / 2; i++) {
            Boolean flag = Boolean.TRUE;
            for (int j = 0; j < len - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = Boolean.FALSE;
                }
            }
            if (flag) {
                break;
            }
            flag = Boolean.TRUE;
            for (int z = len - i; z > i; z--) {
                if (array[z] < array[z - 1]) {
                    temp = array[z];
                    array[z] = array[z - 1];
                    array[z - 1] = temp;
                    flag = Boolean.FALSE;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void sort2(int[] array) {
        int temp = 0;
        //�������е���߽磬ÿ�αȽ�ֻ��Ҫ�ȵ�����Ϊֹ
        int leftSortBorder = 0;
        //�������е��ұ߽磬ÿ�αȽ�ֻ��Ҫ�ȵ�����Ϊֹ
        int rightSortBorder = array.length - 1;
        //��¼������һ�ν�����λ��
        int leftLastChangeIndex = 0;
        //��¼�Ҳ����һ�ν�����λ��
        int rightLastChangeIndex = 0;
        for (int i = 0; i < array.length / 2; i++) {
            Boolean flag = Boolean.TRUE;
            for (int j = leftSortBorder; j < rightSortBorder; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = Boolean.FALSE;
                    rightLastChangeIndex = j;
                }
            }
            rightSortBorder = rightLastChangeIndex;
            if (flag) {
                break;
            }
            flag = Boolean.TRUE;
            for (int z = rightSortBorder; z > leftSortBorder; z--) {
                if (array[z] < array[z - 1]) {
                    temp = array[z];
                    array[z] = array[z - 1];
                    array[z - 1] = temp;
                    flag = Boolean.FALSE;
                    leftLastChangeIndex = z;
                }
            }
            leftSortBorder = leftLastChangeIndex;
            if (flag) {
                break;
            }
        }
    }

}
