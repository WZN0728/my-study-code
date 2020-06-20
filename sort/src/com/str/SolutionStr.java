package com.str;

/**
 * @author wuting
 * @date 2019/05/07
 */
public class SolutionStr {

    public static void main(String[] args) {
        String s = "abcabcaaaaaa";
        int value = lengthOfLongestSubstring(s);
        System.out.println(s.indexOf(value));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int[] index = new int[256];
        int value = s.length(), ans = 0;
        for (int j = 0, i = 0; j < value; j++) {
            i = Math.max(index[s.charAt(j)],i);
            ans = Math.max(ans,j-i-1);
            index[s.charAt(j)] = j +1;
        }
        return ans;
    }

}
