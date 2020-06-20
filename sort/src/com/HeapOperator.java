package com;

import java.util.Arrays;

/**
 * @author wuting
 * @date 2019/03/28
 */
public class HeapOperator {

    private static long startTime;

    private static long endTime;

    /**
     * 二叉堆的自我调整(删除节点,插入节点,自我调整)
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        startTime = System.nanoTime();
        upAdjust(array);
        endTime = System.nanoTime();
        System.out.println(Arrays.toString(array));
        System.out.println("二叉堆上浮运行时间： " + (endTime - startTime) + "ns");
        int[] array1 = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        startTime = System.nanoTime();
        buildHeap(array1);
        endTime = System.nanoTime();
        System.out.println(Arrays.toString(array1));
        System.out.println("二叉堆下沉运行时间： " + (endTime - startTime) + "ns");
    }

    //调整二叉堆 上浮
    public static void upAdjust(int[] array) {
        //取整个数组得长度
        int childIndex = array.length - 1;
        //每一个子节点得小标再数组中的位置为:childIndex = 2*parentIndex + 1,从而得到下面的计算方法
        int parentIndex = (childIndex - 1) / 2;
        //暂存即将插入的子节点得值
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]) {
            //无需真正的交换,单向赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
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

    public static void buildHeap(int[] array) {
        for (int i = array.length / 2; i >= 0; i--) {
            downAdjust(array, i, array.length - 1);
        }
    }

}
