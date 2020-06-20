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
     * ����ѵ����ҵ���(ɾ���ڵ�,����ڵ�,���ҵ���)
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        startTime = System.nanoTime();
        upAdjust(array);
        endTime = System.nanoTime();
        System.out.println(Arrays.toString(array));
        System.out.println("������ϸ�����ʱ�䣺 " + (endTime - startTime) + "ns");
        int[] array1 = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        startTime = System.nanoTime();
        buildHeap(array1);
        endTime = System.nanoTime();
        System.out.println(Arrays.toString(array1));
        System.out.println("������³�����ʱ�䣺 " + (endTime - startTime) + "ns");
    }

    //��������� �ϸ�
    public static void upAdjust(int[] array) {
        //ȡ��������ó���
        int childIndex = array.length - 1;
        //ÿһ���ӽڵ��С���������е�λ��Ϊ:childIndex = 2*parentIndex + 1,�Ӷ��õ�����ļ��㷽��
        int parentIndex = (childIndex - 1) / 2;
        //�ݴ漴��������ӽڵ��ֵ
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]) {
            //���������Ľ���,����ֵ����
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    //��������� �³�
    public static void downAdjust(int[] array, int parentIndex, int length) {
        //�ݴ游�ڵ��ֵ
        int temp = array[parentIndex];
        //��ȡ�ӽڵ��������е�λ��
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            //�ж��Ƿ����ҽڵ㲢���ҽڵ�С����ڵ��ֵ,��λ���Ҳ�ڵ�
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            if (temp < array[childIndex]) {
                break;
            }
            //���������Ľ���,����ֵ����
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
