package com.quickSort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author wuting
 * @date 2019/05/18
 */
public class QuickSortDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 1, 22, 11, 41, 34, 5, 88};
        System.out.println("��ʼ����:" + Arrays.toString(arr));
        //qucikSortByDigui(arr, 0, arr.length - 1);
        qucikSortByStack(arr, 0, arr.length - 1);
        System.out.println("���ս��:" + Arrays.toString(arr));
    }

    private static void qucikSortByStack(int[] arr, int startIndex, int endIndex) {
        Stack<Map<String, Integer>> rootParam = new Stack<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex", startIndex);
        map.put("endIndex", endIndex);
        rootParam.push(map);
        while (!rootParam.isEmpty()) {
            Map<String, Integer> map1 = rootParam.pop();
            int pivot = partation(arr, map1.get("startIndex"), map1.get("endIndex"));
            if (map1.get("startIndex") < pivot - 1) {
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", map1.get("startIndex"));
                leftParam.put("endIndex", pivot - 1);
                rootParam.push(leftParam);
            }
            if (map1.get("endIndex") > pivot + 1) {
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", pivot + 1);
                rightParam.put("endIndex", map1.get("endIndex"));
                rootParam.push(rightParam);
            }
        }
    }

    private static void qucikSortByDigui(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        //˫��,�����߶ԱȻ�׼Ԫ��
        //int povit = partation(arr, startIndex, endIndex);
        //����,��һ�߶ԱȻ�׼Ԫ��
        int povit = partation2(arr, startIndex, endIndex);
        System.out.println("����ֵ" + povit);
        qucikSortByDigui(arr, startIndex, povit - 1);
        qucikSortByDigui(arr, povit + 1, endIndex);
    }

    private static int partation2(int[] arr, int startIndex, int endIndex) {
        int povit = arr[startIndex], mark = startIndex;
        for (int i = startIndex + 1; i < endIndex; i++) {
            if (arr[i] < povit) {
                mark++;
                int temp = arr[mark];
                arr[mark] = arr[i];
                arr[i] = temp;
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = povit;
        return mark;
    }

    private static int partation(int[] arr, int startIndex, int endIndex) {
        int left = startIndex, right = endIndex, povit = arr[startIndex];
        while (left != right) {
            while (left < right && arr[right] > povit) {
                right--;
            }
            while (left < right && arr[left] <= povit) {
                left++;
            }
            if (left < right) {
                int param = arr[left];
                arr[left] = arr[right];
                arr[right] = param;
            }
            System.out.println("whileѭ����:" + Arrays.toString(arr));
        }
        //�����غϵ�
        arr[startIndex] = arr[left];
        arr[left] = povit;
        System.out.println("whileѭ����:" + Arrays.toString(arr));
        return left;
    }


}
