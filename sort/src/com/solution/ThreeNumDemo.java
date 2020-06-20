package com.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wuting
 * @date 2019/05/19
 */
public class ThreeNumDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 7, 3, 4, 8, 6, 5, 9, 3};
        List list = threeNumSolution(arr, 10);
        System.out.println(Arrays.toString(list.toArray()));
    }

    private static List threeNumSolution(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }
        Collections.sort(numsList);
        int len = numsList.size();
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && numsList.get(i - 1).equals(numsList.get(i))) {
                continue;
            }
            Integer a = numsList.get(i);
            int low = i + 1;
            int high = len - 1;
            while (low < high) {
                Integer b = numsList.get(low);
                Integer c = numsList.get(high);
                if ((a + b + c) == target) {
                    List<Integer> tl = new ArrayList<>();
                    tl.add(a);
                    tl.add(b);
                    tl.add(c);
                    list.add(tl);
                    while (low < len - 1 && numsList.get(low).equals(numsList.get(low + 1))) {
                        low++;
                    }
                    while (high > 0 && numsList.get(high).equals(numsList.get(high - 1))) {
                        high--;
                    }
                    low++;
                    high--;
                } else if ((a + b + c) > target) {
                    while (high > 0 && numsList.get(high).equals(numsList.get(high - 1))) {
                        high--;
                    }
                    high--;
                } else {
                    while (low < len - 1 && numsList.get(low).equals(numsList.get(low + 1))) {
                        low++;
                    }
                    low++;
                }
            }
        }
        return list;
    }

}
