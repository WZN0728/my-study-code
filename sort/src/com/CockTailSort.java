package com;

import java.util.Arrays;

/**
 * @author wuting
 * @date 2019/03/28
 */
//鸡尾酒排序
public class CockTailSort {

    private static long startTime;

    private static long endTime;

    /**
     * 类似于钟摆运动,从左到右,从右到左
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {12, 1, 3, 32, 21, 55, 35, 99, 88, 78, 75};
        startTime = System.nanoTime();
        sort1(array);
        endTime = System.nanoTime();
        System.out.print(Arrays.toString(array));
        System.out.println("鸡尾酒算法运行时间： " + (endTime - startTime) + "ns");
        int[] array1 = {12, 1, 3, 32, 21, 55, 35, 99, 88, 78, 75};
        startTime = System.nanoTime();
        sort2(array1);
        endTime = System.nanoTime();
        System.out.print(Arrays.toString(array1));
        System.out.println("优化的鸡尾酒算法运行时间： " + (endTime - startTime) + "ns");
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
        //无序数列的左边界，每次比较只需要比到这里为止
        int leftSortBorder = 0;
        //无序数列的右边界，每次比较只需要比到这里为止
        int rightSortBorder = array.length - 1;
        //记录左侧最后一次交换的位置
        int leftLastChangeIndex = 0;
        //记录右侧最后一次交换的位置
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
