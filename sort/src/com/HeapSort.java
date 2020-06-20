package com;

import java.util.Arrays;

/**
 * @author wuting
 * @date 2019/03/29
 */
public class HeapSort {

    //通过二叉堆实现的堆排序,所谓的堆排序其实就是根据二叉堆删除最顶端节点在进行堆的自我调整来实现的
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //调整二叉堆 下沉
    public static void downAdjust(int[] array, int parentIndex, int length) {
        //暂存父节点的值
        int temp = array[parentIndex];
        //获取子节点再数组中的位置
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            //判断是否有右节点并且右节点小于左节点的值,则定位到右侧节点
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            if (temp < array[childIndex]) {
                break;
            }
            //无需真正的交换,单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    public static void heapSort(int[] array) {
        //把一个无序数组调整二叉堆
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
        System.out.println(Arrays.toString(array));
        //删除堆顶端的节点,移动到最底部
        for (int j = array.length - 1; j > 0; j--) {
            //最后一个元素和第一个元素进行交换
            int temp = array[j];
            array[j] = array[0];
            array[0] = temp;
            //下沉最大节点,调整二叉堆
            downAdjust(array, 0, j);
        }
    }

}
