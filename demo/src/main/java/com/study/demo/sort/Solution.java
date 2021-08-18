package com.study.demo.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wuting
 * @date 2020/01/21
 */
public class Solution {

    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{23, 32, 4, 88, 66, 12, 24, 99, 98};
        //冒泡排序
        //buddleSort(arr);
        //插入排序
        //insertSort(arr);
        //选择排序
        //selectSort(arr);
        //快速排序
        //quickSort(arr, 0, arr.length - 1);
        //归并排序
        mergeSort(0, arr.length - 1, arr);
        //爬楼梯、跳格子问题,一次走一阶或者一次两阶,一次跳一格或者一次跳两格
        //System.out.println(getClimbValue(10));
        //1、1、2、3、5、8、13 ... n
        //System.out.println(fub(6));
        //字符串转为数字
        //System.out.println(toIntValue("532"));
        //字符串匹配
        String str = "dfadhjks";
        String str2 = "dhj";
        System.out.println(getStrPatch(str, str2));
        System.out.println(Arrays.toString(arr));
        System.out.println(randomString(1));
    }

    private static int getStrPatch(String str, String str2) {
        int strLen = str.length();
        int str2Len = str2.length();
        int hashCode2 = hashCode(str2);
        int hashCode = hashCode(str.substring(0, str2Len));
        for (int i = 0; i < strLen - str2Len + i; i++) {
            if (hashCode == hashCode2 && compareStrValue(str, str2, i)) {
                return i;
            }
            if (strLen - str2Len > i) {
                hashCode = nextHash(str, str2Len, hashCode, i);
            }
        }
        return -1;
    }

    private static int nextHash(String str, int str2Len, int hashCode2, int i) {
        hashCode2 -= str.charAt(i) - 'a';
        hashCode2 += str.charAt(i + str2Len) - 'a';
        return hashCode2;
    }

    private static boolean compareStrValue(String str, String str2, int index) {
        return str2.equals(str.substring(index, index + str2.length()));
    }

    private static int hashCode(String str2) {
        int hashCode = 0;
        for (int i = 0; i < str2.length(); i++) {
            hashCode += str2.charAt(i) - 'a';
        }
        return hashCode;
    }

    private static int toIntValue(String s) throws Exception {
        char[] chars = s.toCharArray();
        int result = 0;
        int limit = Integer.MAX_VALUE / 10;
        for (int i = 0; i < chars.length; i++) {
            char value = s.charAt(i);
            if (!Character.isDigit(value)) {
                throw new Exception("不是数字");
            }
            if ((Math.abs(result) >= limit || result <= -limit) && value != '0') {
                throw new Exception("溢出");
            }
            result *= 10;
            result -= value - '0';
        }
        return Math.abs(result);
    }

    private static int fub(int n) {
        if (n <= 0) {
            return -1;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int a = 1, b = 1, c = 0;
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    private static int getClimbValue(int n) {
        if (n <= 0) {
            return -1;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int a = 1, b = 2, c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * jdk的Arrays.sort()方法之所以叫加强归并排序
     * 是因为底层在判断整个数组的长度小于7的时候直接使用Java的Comparator方式排序
     * 究其原因可能是jdk通过大量的运算得出过长度小于7时归并算法并不是最理想得
     *
     * @param start
     * @param end
     * @param arr
     */
    private static void mergeSort(int start, int end, int[] arr) {
        if (start > end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(start, mid, arr);
        mergeSort(mid + 1, end, arr);
        mergeSortFun(start, mid, end, arr);
    }

    private static void mergeSortFun(int start, int mid, int end, int[] arr) {
        int p0 = start;
        int p1 = mid + 1;
        int[] tempArray = new int[end + 1];
        int p = 0;
        while (p0 <= mid && mid <= end) {
            if (arr[p0] < arr[p1]) {
                arr[p++] = arr[p0++];
            } else {
                arr[p++] = arr[p1++];
            }
        }
        while (p0 <= mid) {
            arr[p++] = arr[p0++];
        }
        while (p1 <= end) {
            arr[p++] = arr[p1++];
        }
        for (int i = 0; i < tempArray.length; i++) {
            arr[i + start] = tempArray[i];
        }
    }

    private static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int povit = partition(arr, startIndex, endIndex);
        quickSort(arr, startIndex, povit - 1);
        quickSort(arr, povit + 1, endIndex);
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        int povit = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while (left < right && arr[right] > povit) {
                right--;
            }
            while (left < right && arr[left] <= povit) {
                left++;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        int p = arr[left];
        arr[left] = arr[startIndex];
        arr[startIndex] = p;
        return left;
    }

    private static void selectSort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                minIndex = arr[j] > arr[minIndex] ? minIndex : j;
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    private static void insertSort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            int insertValue = arr[i];
            int j = i - 1;
            for (; j >= 0 && insertValue < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = insertValue;
        }
    }

    private static void buddleSort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static String randomString(int i) {
        Random ran = new Random(i);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int k = ran.nextInt(27);
            if (k == 0) {
                break;
            }
            sb.append((char) ('`' + k));
        }
        return sb.toString();
    }

}
