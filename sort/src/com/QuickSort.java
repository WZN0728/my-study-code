/**
 *
 */
package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <p>
 * 标题：sort
 * </p>
 * <p>
 * 描述：QuickSort
 * </p>
 * <p>
 * 编译者：wuting
 * </p>
 * <p>
 * 版本：1.0
 * </p>
 * <p>
 * 文件名：com.QuickSort.java
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
 * 创建时间：2016年11月23日上午10:56:15
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
 * 修改时间：2016年11月23日上午10:56:15
 * </p>
 * <p>
 * 修改内容：
 * </p>
 */
public class QuickSort {

    private static long startTime;

    private static long endTime;

    /**
     * 快速排序是对冒泡排序的一种改进。基本思想是：
     * 选择一个基准元素,通过一趟排序将要排序的数据分割成独立的两部分，其中一部分比基准元素小,另一部分的所有数据比基准元素大，
     * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此实现整个数据变成有序序列。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {12, 1, 3, 32, 21, 55, 35, 99, 88, 78, 75};
        startTime = System.nanoTime();
        quickSort1(array, 0, array.length - 1);
        endTime = System.nanoTime();
        System.out.print(Arrays.toString(array));
        System.out.println("递归快速排序算法运行时间： " + (endTime - startTime) + "ns");
        int[] array1 = {12, 1, 3, 32, 21, 55, 35, 99, 88, 78, 75};
        startTime = System.nanoTime();
        quickSortByStack(array1, 0, array1.length - 1);
        endTime = System.nanoTime();
        System.out.print(Arrays.toString(array1));
        System.out.println("基于栈快速排序算法运行时间： " + (endTime - startTime) + "ns");
    }

    // 快速排序
    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = array[left];
            int low = left;
            int high = right;
            while (low < high) {
                while (low < high && array[high] >= pivot) {
                    // 一直减到low>=high
                    high--;
                }
                // 比基准元素小的移动到前
                array[low] = array[high];
                while (low < high && array[low] <= pivot) {
                    // 一直加到low>=high
                    low++;
                }
                // 比基准元素大的移动到尾
                array[high] = array[low];
            }
            // 基准元素到尾
            array[low] = pivot;
            // 对低端元素排序
            quickSort(array, left, low - 1);
            // 对高端元素排序
            quickSort(array, low + 1, right);
        }
    }

    public static void quickSort1(int[] array, int left, int right) {
        if (left < right) {
            int low = left;
            int high = right;
            int middle = array[low];
            while (low < high) {
                while (low < high && array[high] > middle) {
                    high--;
                }
                array[low] = array[high];
                while (low < high && array[low] <= middle) {
                    low++;
                }
                array[high] = array[low];
            }
            array[low] = middle;
            quickSort1(array, left, low - 1);
            quickSort1(array, low + 1, right);
        }
    }

    public static void quickSortByStack(int[] arr, int startIndex, int endIndex) {
        // 用一个集合栈来代替递归的函数栈
        Stack<Map<String, Integer>> stack = new Stack<Map<String, Integer>>();
        // 整个数列的起止下标，以哈希的形式入栈
        Map<String, Integer> rootParam = new HashMap();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        stack.push(rootParam);
        // 循环结束条件：栈为空时结束
        while (!stack.isEmpty()) {
            // 栈顶元素出栈，得到起止下标
            Map<String, Integer> param = stack.pop();
            // 得到基准元素位置
            int pivotIndex = partation(arr, rootParam.get("startIndex"), rootParam.get("endIndex"));
            // 根据基准元素分成两部分, 把每一部分的起止下标入栈
            if (param.get("startIndex") < pivotIndex - 1) {
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivotIndex - 1);
                stack.push(leftParam);
            }
            if (param.get("endIndex") > pivotIndex + 1) {
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", pivotIndex + 1);
                rightParam.put("endIndex", param.get("endIndex"));
                stack.push(rightParam);
            }
        }
    }

    private static int partation(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            //控制right指针比较并左移
            while (left < right && arr[right] > pivot) {
                right--;
            }
            //控制right指针比较并右移
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            //交换left和right指向的元素
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        //pivot和指针重合点交换
        int i = arr[left];
        arr[left] = arr[startIndex];
        arr[startIndex] = i;
        return left;
    }

}