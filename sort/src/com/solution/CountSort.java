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
        //��������е����ֵ��������Ϊû��Ҫ����������ֵ��
        ֻ��Ҫ��ԭ����ĳ��ȸ�ֵ�������鼴�ɣ�
        ��Ϊ������������鶼���ᳬ��ԭ����ĳ��ȣ���Ϊ���ݾ���Щ
        for(int i=0;i<index.length;i++){
            if(index[i] > max){
                max = index[i];
            }
        }*/
        int[] arr = new int[index.length];
        for (int i = 0; i < index.length; i++) {
            //index[i]�ǻ�ȡԭʼ�����ֵvalue
            //arr[index[i]]++�����������ж�Ӧԭ����valueֵ�Ǹ�λ��������
            arr[index[i]]++;
        }
        //��������,������
        int z = 0;
        int[] sortArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                //�ؼ�������z������
                sortArr[z++] = i;
            }
        }
        return sortArr;
    }

}
