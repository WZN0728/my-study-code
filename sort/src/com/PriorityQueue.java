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

    //������ȶ��У��������˳�򣬵�ǰ����Ԫ�����ȳ���
    //��С���ȶ��У��������˳�򣬵�ǰ��С��Ԫ�����ȳ���
    //1.���ѵĶѶ����������е����Ԫ��
    //2.��С�ѵĶѶ����������е���СԪ��
    //��ˣ����ǿ�����������ʵ��������ȶ��У�
    //ÿһ����Ӳ������ǶѵĲ��������ÿһ�γ��Ӳ�������ɾ���Ѷ��ڵ�
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(7);
        System.out.println("������Ķ�:" + Arrays.toString(array));
        System.out.println("����Ԫ��:" + priorityQueue.deQueue());
        System.out.println("����Ԫ��:" + priorityQueue.deQueue());
    }

    //���
    public void enQueue(int key) {
        if (this.size >= array.length) {
            resize();
        }
        array[size++] = key;
        upAdjust();
    }

    public int deQueue() {
        if (size < 0) {
            throw new RuntimeException("��ǰ������ֵ");
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

    //��������� �ϸ�
    public void upAdjust() {
        //ȡ��������ó���
        int childIndex = array.length - 1;
        //ÿһ���ӽڵ��С���������е�λ��Ϊ:childIndex = 2*parentIndex + 1,�Ӷ��õ�����ļ��㷽��
        int parentIndex = (childIndex - 1) / 2;
        //�ݴ漴��������ӽڵ��ֵ
        int temp = array[childIndex];
        while (childIndex > 0 && temp > array[parentIndex]) {
            //���������Ľ���,����ֵ����
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = parentIndex / 2;
        }
        array[childIndex] = temp;
    }

    //��������� �³�
    public void downAdjust() {
        int parentIndex = 0;
        //�ݴ�Ѷ�Ԫ��
        int temp = array[parentIndex];
        //��ȡ�ӽڵ��������е�λ��
        int childIndex = 1;
        while (childIndex < size) {
            //�ж��Ƿ����ҽڵ㲢���ҽڵ�С����ڵ��ֵ,��λ���Ҳ�ڵ�
            if (childIndex + 1 < size && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            // ������ڵ�����κ�һ�����ӵ�ֵ��ֱ������
            if (temp >= array[childIndex]) {
                break;
            }
            //���������Ľ���,����ֵ����
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

}
