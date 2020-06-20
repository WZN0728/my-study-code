package com.insertionSort;

import java.util.Arrays;

/**
 * @author wuting
 * @date 2019/06/09
 */
public class InsertionSort {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{23, 3, 2, 5, 82, 12, 4};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = new int[]{23, 3, 2, 5, 82, 12, 4};
        insertionSort2(arr2);
        //mpSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    private static <T extends Comparable> void insertionSort(T[] arr) {
        int j;
        //从第二个元素开始向前比较
        for (int i = 1; i < arr.length; i++) {
            T temp = arr[i];//temp=3
            //如果后面的元素大于前边的元素就交换23, 3---》 23,23
            for (j = i; (j > 0) && (temp.compareTo(arr[j - 1])) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            //将后面的元素赋值给前一个值
            arr[j] = temp;//j=0,arr[j]=23,temp=3
        }
    }

    private static void insertionSort2(int[] arr) {
        int j;
        for (int i = 1; i < arr.length; i++) {
            for (j = i; (j > 0) && (arr[j] < arr[j - 1]); j--) {
                int temp2 = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp2;
            }
        }
    }

    /*private static void mpSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }*/

}
