package com;

import java.util.Arrays;

/**
 * @author wuting
 * @date 2019/03/29
 */
public class PriorityQueue {

    private static int[] array;

    private int size;

    static {
        array = new int[32];
    }

    //最大优先队列，无论入队顺序，当前最大的元素优先出队
    //最小优先队列，无论入队顺序，当前最小的元素优先出队
    //1.最大堆的堆顶是整个堆中的最大元素
    //2.最小堆的堆顶是整个堆中的最小元素
    //因此，我们可以用最大堆来实现最大优先队列，
    //每一次入队操作就是堆的插入操作，每一次出队操作就是删除堆顶节点
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(7);
        System.out.println("调整后的堆:" + Arrays.toString(array));
        System.out.println("出队元素:" + priorityQueue.deQueue());
        System.out.println("出队元素:" + priorityQueue.deQueue());
    }

    //入队
    public void enQueue(int key) {
        if (this.size >= array.length) {
            resize();
        }
        array[size++] = key;
        upAdjust();
    }

    public int deQueue() {
        if (size < 0) {
            throw new RuntimeException("当前队列无值");
        }
        int head = array[0];
        array[0] = array[size--];
        downAdjust();
        return head;
    }

    private void resize() {
        int newSize = this.size * 2;
        Arrays.copyOf(array, newSize);
    }

    //调整二叉堆 上浮
    public void upAdjust() {
        //取整个数组得长度
        int childIndex = array.length - 1;
        //每一个子节点得小标再数组中的位置为:childIndex = 2*parentIndex + 1,从而得到下面的计算方法
        int parentIndex = (childIndex - 1) / 2;
        //暂存即将插入的子节点得值
        int temp = array[childIndex];
        while (childIndex > 0 && temp > array[parentIndex]) {
            //无需真正的交换,单向赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = parentIndex / 2;
        }
        array[childIndex] = temp;
    }

    //调整二叉堆 下沉
    public void downAdjust() {
        int parentIndex = 0;
        //暂存堆顶元素
        int temp = array[parentIndex];
        //获取子节点再数组中的位置
        int childIndex = 1;
        while (childIndex < size) {
            //判断是否有右节点并且右节点小于左节点的值,则定位到右侧节点
            if (childIndex + 1 < size && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            // 如果父节点大于任何一个孩子的值，直接跳出
            if (temp >= array[childIndex]) {
                break;
            }
            //无需真正的交换,单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

}
