package com;

import java.util.Arrays;

/**
 * @author wuting
 * @date 2019/04/05
 */
public class OperationStr {

    //�ַ������鷴ת
    public static void main(String[] args) {
        String s = "HeLLO";
        System.out.println(firstLower(s));
        String[] value = {"h", "e", "l", "l", "o"};
        System.out.println(Arrays.toString(getReverse(value)));
        System.out.println(checkPalindrome("level"));
    }

    public static String[] getReverse(String[] value) {
        int i = 0, j = value.length - 1;
        while (i < j) {
            String s = value[i];
            value[i] = value[j];
            value[j] = s;
            i++;
            j--;
        }
        return value;
    }

    public static String firstLower(String s) {
        char[] chars = s.toCharArray();
        //תСд
        chars[0] += 32;
        //ת��д
        chars[1] -= 32;
        return String.valueOf(chars);
    }

    //�ж��ַ����Ƿ�Ϊ������
    public static Boolean checkPalindrome(String value) {
        if (value.length() == 0) {
            return false;
        }
        int i = 0, j = value.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(value.charAt(i))) {
                i++;
            } else if (!Character.isLetterOrDigit(value.charAt(j))) {
                j--;
            } else {
                if (Character.isLetterOrDigit(value.charAt(i)) != Character.isLetterOrDigit(value.charAt(j))) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

}
