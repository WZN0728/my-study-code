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
 * ���⣺sort
 * </p>
 * <p>
 * ������QuickSort
 * </p>
 * <p>
 * �����ߣ�wuting
 * </p>
 * <p>
 * �汾��1.0
 * </p>
 * <p>
 * �ļ�����com.QuickSort.java
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
 * ����ʱ�䣺2016��11��23������10:56:15
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
 * �޸�ʱ�䣺2016��11��23������10:56:15
 * </p>
 * <p>
 * �޸����ݣ�
 * </p>
 */
public class QuickSort {

    private static long startTime;

    private static long endTime;

    /**
     * ���������Ƕ�ð�������һ�ָĽ�������˼���ǣ�
     * ѡ��һ����׼Ԫ��,ͨ��һ������Ҫ��������ݷָ�ɶ����������֣�����һ���ֱȻ�׼Ԫ��С,��һ���ֵ��������ݱȻ�׼Ԫ�ش�
     * Ȼ���ٰ��˷����������������ݷֱ���п�����������������̿��Եݹ���У��Դ�ʵ���������ݱ���������С�
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {12, 1, 3, 32, 21, 55, 35, 99, 88, 78, 75};
        startTime = System.nanoTime();
        quickSort1(array, 0, array.length - 1);
        endTime = System.nanoTime();
        System.out.print(Arrays.toString(array));
        System.out.println("�ݹ���������㷨����ʱ�䣺 " + (endTime - startTime) + "ns");
        int[] array1 = {12, 1, 3, 32, 21, 55, 35, 99, 88, 78, 75};
        startTime = System.nanoTime();
        quickSortByStack(array1, 0, array1.length - 1);
        endTime = System.nanoTime();
        System.out.print(Arrays.toString(array1));
        System.out.println("����ջ���������㷨����ʱ�䣺 " + (endTime - startTime) + "ns");
    }

    // ��������
    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = array[left];
            int low = left;
            int high = right;
            while (low < high) {
                while (low < high && array[high] >= pivot) {
                    // һֱ����low>=high
                    high--;
                }
                // �Ȼ�׼Ԫ��С���ƶ���ǰ
                array[low] = array[high];
                while (low < high && array[low] <= pivot) {
                    // һֱ�ӵ�low>=high
                    low++;
                }
                // �Ȼ�׼Ԫ�ش���ƶ���β
                array[high] = array[low];
            }
            // ��׼Ԫ�ص�β
            array[low] = pivot;
            // �ԵͶ�Ԫ������
            quickSort(array, left, low - 1);
            // �Ը߶�Ԫ������
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
        // ��һ������ջ������ݹ�ĺ���ջ
        Stack<Map<String, Integer>> stack = new Stack<Map<String, Integer>>();
        // �������е���ֹ�±꣬�Թ�ϣ����ʽ��ջ
        Map<String, Integer> rootParam = new HashMap();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        stack.push(rootParam);
        // ѭ������������ջΪ��ʱ����
        while (!stack.isEmpty()) {
            // ջ��Ԫ�س�ջ���õ���ֹ�±�
            Map<String, Integer> param = stack.pop();
            // �õ���׼Ԫ��λ��
            int pivotIndex = partation(arr, rootParam.get("startIndex"), rootParam.get("endIndex"));
            // ���ݻ�׼Ԫ�طֳ�������, ��ÿһ���ֵ���ֹ�±���ջ
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
        // ȡ��һ��λ�õ�Ԫ����Ϊ��׼Ԫ��
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            //����rightָ��Ƚϲ�����
            while (left < right && arr[right] > pivot) {
                right--;
            }
            //����rightָ��Ƚϲ�����
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            //����left��rightָ���Ԫ��
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        //pivot��ָ���غϵ㽻��
        int i = arr[left];
        arr[left] = arr[startIndex];
        arr[startIndex] = i;
        return left;
    }

}