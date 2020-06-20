package com.solution;

import java.util.Arrays;

/**
 * @author wuting
 * @date 2019/05/13
 */
public class CountSort {

    public static void main(String[] args) {
        int[] index = new int[]{7, 8, 9, 3, 4, 9, 0, 2, 1, 3, 10};
        int[] result = countIndex(index);
        System.out.println(Arrays.toString(result));
    }

    private static int[] countIndex(int[] index) {
        /*int max = 0;
        //求出数组中的最大值，个人认为没必要算出数组最大值，
        只需要把原数组的长度赋值给新数组即可，
        因为无论如何新数组都不会超出原数组的长度，因为数据就那些
        for(int i=0;i<index.length;i++){
            if(index[i] > max){
                max = index[i];
            }
        }*/
        int[] arr = new int[index.length];
        for (int i = 0; i < index.length; i++) {
            //index[i]是获取原始数组的值value
            //arr[index[i]]++是在新数组中对应原数组value值那个位置做自增
            arr[index[i]]++;
        }
        //遍历数组,输出结果
        int z = 0;
        int[] sortArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                //关键处在于z的自增
                sortArr[z++] = i;
            }
        }
        return sortArr;
    }

}
