package com.quickSort;

import java.util.Arrays;

/**
 * @author wuting
 * @date 2019/05/18
 */
public class QuickSortDemo2 {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 1, 22, 11, 41, 34, 5, 88};
        System.out.println("初始数据:" + Arrays.toString(arr));
        qucikSort(arr, 0, arr.length - 1);
        System.out.println("最终结果:" + Arrays.toString(arr));
        Arrays.sort(arr);
    }

    private static void qucikSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        //int povit = partation(arr, startIndex, endIndex);
        int povit = partation2(arr, startIndex, endIndex);
        qucikSort(arr, startIndex, povit - 1);
        qucikSort(arr, povit + 1, endIndex);
    }

    private static int partation2(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex], mark = startIndex;
        for (int i = startIndex + 1; i < endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                int temp = arr[i];
                arr[i] = arr[mark];
                arr[mark] = temp;
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    private static int partation(int[] arr, int startIndex, int endIndex) {
        int left = startIndex, right = endIndex, pivot = arr[startIndex];
        while (left != right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }


}
