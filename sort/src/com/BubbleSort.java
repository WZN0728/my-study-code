/**
 *
 */
package com;

import java.util.Arrays;

/**
 * <p>
 * 标题：sort
 * </p>
 * <p>
 * 描述：SortArray
 * </p>
 * <p>
 * 编译者：wuting
 * </p>
 * <p>
 * 版本：1.0
 * </p>
 * <p>
 * 文件名：com.SortArray.java
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
 * 创建时间：2016年11月22日下午2:24:40
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
 * 修改时间：2016年11月22日下午2:24:40
 * </p>
 * <p>
 * 修改内容：
 * </p>
 */
//冒泡排序及排序优化
public class BubbleSort {

    private static long startTime;

    private static long endTime;

    /**
     * 1.1 算法原理： S1：从待排序序列的起始位置开始，从前往后依次比较各个位置和其后一位置的大小并执行S2。
     * S2：如果当前位置的值大于其后一位置的值，就把他俩的值交换（完成一次全序列比较后，序列最后位置的值即此序列最大值，所以其不需要再参与冒泡）。
     * S3：将序列的最后位置从待排序序列中移除。若移除后的待排序序列不为空则继续执行S1，否则冒泡结束。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {12, 1, 3, 32, 21, 55, 35, 99, 88, 78, 75};
        startTime = System.nanoTime();
        bubbleSort(array);
        endTime = System.nanoTime();
        System.out.println(Arrays.toString(array));
        System.out.println("未优化的冒泡算法运行时间： " + (endTime - startTime) + "ns");
        int[] array1 = {12, 1, 3, 32, 21, 55, 35, 99, 88, 78, 75};
        startTime = System.nanoTime();
        bubbleSortOptimization(array1);
        endTime = System.nanoTime();
        System.out.println(Arrays.toString(array1));
        System.out.println("优化的冒泡算法运行时间： " + (endTime - startTime) + "ns");
        int[] array2 = {12, 1, 3, 32, 21, 55, 35, 99, 88, 78, 75};
        startTime = System.nanoTime();
        bubbleSortOptimization2(array2);
        endTime = System.nanoTime();
        System.out.println(Arrays.toString(array2));
        System.out.println("再次优化的冒泡算法运行时间： " + (endTime - startTime) + "ns");
    }

    // 冒泡算法,未优化
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

    // 优化后的冒泡算法(若某一趟排序中未进行一次交换，则排序结束)
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
        //记录最后一次交换的位置
        int lastChangeIndex = 0;
        //无序数列的边界，每次比较只需要比到这里为止
        int sortPosition = array.length - 1;
        for (int i = 0; i < len; i++) {
            //有序标记，每一轮的初始是true
            boolean flag = true;
            for (int j = 0; j < sortPosition; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    //把无序数列的边界更新为最后一次交换元素的位置
                    lastChangeIndex = j;
                    //有元素交换，所以不是有序，标记变为false
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