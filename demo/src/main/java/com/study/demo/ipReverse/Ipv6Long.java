package com.study.demo.ipReverse;

import java.util.Arrays;

/**
 * @author wuting
 * @date 2019/03/20
 */
public class Ipv6Long {

    /**
     * 将 IPv6 地址转为 long 数组，只支持冒分十六进制表示法
     */
    public static long[] ip2Longs(String ipString) {
        if (ipString == null || ipString.isEmpty()) {
            throw new IllegalArgumentException("ipString cannot be null.");
        }
        String[] ipSlices = ipString.split(":");
        if (ipSlices.length != 8) {
            throw new IllegalArgumentException(ipString + " is not an ipv6 address.");
        }
        long[] ipv6 = new long[2];
        for (int i = 0; i < 8; i++) {
            String slice = ipSlices[i];
            // 以 16 进制解析
            long num = Long.parseLong(slice, 16);
            // 每组 16 位
            long right = num << (16 * i);
            // 每个 long 保存四组，i >> 2 = i / 4
            ipv6[i >> 2] |= right;
        }
        return ipv6;
    }

    /**
     * 将 long 数组转为冒分十六进制表示法的 IPv6 地址
     */
    public static String longs2Ip(long[] numbers) {
        if (numbers == null || numbers.length != 2) {
            throw new IllegalArgumentException(Arrays.toString(numbers) + " is not an IPv6 address.");
        }
        StringBuilder sb = new StringBuilder(32);
        for (long numSlice : numbers) {
            // 每个 long 保存四组
            for (int j = 0; j < 4; j++) {
                // 取最后 16 位
                long current = numSlice & 0xFFFF;
                sb.append(Long.toString(current, 16)).append(":");
                // 右移 16 位，即去除掉已经处理过的 16 位
                numSlice >>= 16;
            }
        }
        // 去掉最后的 :
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        String[] ips4Test = new String[]{"FFFF:FFFF:7654:FEDA:1245:BA98:3210:4562",
                "FFFF:FFFF:FFFF:FFFF:FFFF:FFFF:FFFF:FFFF", "7654:0:FFFF:7654:562:222:7622:0", "0:0:0:0:0:0:0:0"};
        for (String testCase : ips4Test) {
            test(testCase);
        }
    }

    private static void test(String testCase) {
        long[] ipv6 = ip2Longs(testCase);
        String ipString = longs2Ip(ipv6);
        boolean eq = testCase.equalsIgnoreCase(ipString);
        System.out.println("本次测试 ipv6 地址: " + testCase + ", 转为 long 数组: " + Arrays.toString(ipv6)
                + ", 再转回 ipv6 字符串: " + ipString + ", 是否与原字符串相等: " + eq);
        if (!eq) {
            throw new IllegalStateException("本次测试未通过！testCase: " + testCase);
        }
    }

}
