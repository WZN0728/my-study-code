/**
 *
 */
package com;

/**
 * <p>
 * 标题：sort
 * </p>
 * <p>
 * 描述：Fub
 * </p>
 * <p>
 * 编译者：wuting
 * </p>
 * <p>
 * 版本：1.0
 * </p>
 * <p>
 * 文件名：com.Fub.java
 * </p>
 * <p>
 * 版权：Copyright (c) 2002-2016 Digitalchina CO.,LTD. All rights reserved.
 * </p>
 * <p>
 * 公司：神州数码系统集成服务有限公司
 * </p>
 * <p>
 * 作者：wuting
 * </p>
 * <p>
 * 创建时间：2016年12月15日上午11:17:06
 * </p>
 * <p>
 * 负责人：wuting
 * </p>
 * <p>
 * 部门：工程院安全可靠研发中心产品研发部
 * </p>
 * <p>
 * 修改者：wuting
 * </p>
 * <p>
 * 修改时间：2016年12月15日上午11:17:06
 * </p>
 * <p>
 * 修改内容：
 * </p>
 */
public class Fub {

    private static long startTime;

    private static long endTime;

    /**
     * 基本思想：将1、1、2、3、5、8、13、21、34、……以F(1)=1，F(2)=1,
     * F(n)=F(n-1)+F(n-2)（n>2，n∈N*）的方式编程
     *
     * @param args
     */
    public static void main(String[] args) {
        startTime = System.nanoTime();
        System.out.println(fubDigui(6));
        endTime = System.nanoTime();
        System.out.println("递归算法运行时间为：" + (endTime - startTime) + "ns");
        startTime = System.nanoTime();
        System.out.println(fubVarible(6));
        endTime = System.nanoTime();
        System.out.println("变量for循环算法运行时间为：" + (endTime - startTime) + "ns");
        startTime = System.nanoTime();
        System.out.println(fubArray(6));
        endTime = System.nanoTime();
        System.out.println("数组for循环算法运行时间为：" + (endTime - startTime) + "ns");
    }

    // 递归计算斐波那契数列
    public static int fubDigui(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fubDigui(n - 1) + fubDigui(n - 2);
    }

    // 变量for循环方式计算斐波那契数列
    public static int fubVarible(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 1, b = 1, c = 0;
        for (int i = 0; i < n - 2; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    // 数组for循环方式计算斐波那契数列
    public static int fubArray(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] array = new int[n];
        array[0] = array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n - 1];
    }

}