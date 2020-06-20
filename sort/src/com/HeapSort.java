package com;

import java.util.Arrays;

/**
 * @author wuting
 * @date 2019/03/29
 */
public class HeapSort {

    //ͨ�������ʵ�ֵĶ�����,��ν�Ķ�������ʵ���Ǹ��ݶ����ɾ����˽ڵ��ڽ��жѵ����ҵ�����ʵ�ֵ�
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
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

    public static void heapSort(int[] array) {
        //��һ������������������
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
        System.out.println(Arrays.toString(array));
        //ɾ���Ѷ��˵Ľڵ�,�ƶ�����ײ�
        for (int j = array.length - 1; j > 0; j--) {
            //���һ��Ԫ�غ͵�һ��Ԫ�ؽ��н���
            int temp = array[j];
            array[j] = array[0];
            array[0] = temp;
            //�³����ڵ�,���������
            downAdjust(array, 0, j);
        }
    }

}
