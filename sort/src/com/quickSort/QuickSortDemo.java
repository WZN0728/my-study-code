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
        System.out.println("初始数据:" + Arrays.toString(arr));
        //qucikSortByDigui(arr, 0, arr.length - 1);
        qucikSortByStack(arr, 0, arr.length - 1);
        System.out.println("最终结果:" + Arrays.toString(arr));
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
        //双边,从两边对比基准元素
        //int povit = partation(arr, startIndex, endIndex);
        //单边,从一边对比基准元素
        int povit = partation2(arr, startIndex, endIndex);
        System.out.println("返回值" + povit);
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
            System.out.println("while循环内:" + Arrays.toString(arr));
        }
        //交换重合的
        arr[startIndex] = arr[left];
        arr[left] = povit;
        System.out.println("while循环外:" + Arrays.toString(arr));
        return left;
    }


}
