/**
 *
 */
package com;

/**
 * <p>
 * ���⣺sort
 * </p>
 * <p>
 * ������Fub
 * </p>
 * <p>
 * �����ߣ�wuting
 * </p>
 * <p>
 * �汾��1.0
 * </p>
 * <p>
 * �ļ�����com.Fub.java
 * </p>
 * <p>
 * ��Ȩ��Copyright (c) 2002-2016 Digitalchina CO.,LTD. All rights reserved.
 * </p>
 * <p>
 * ��˾����������ϵͳ���ɷ������޹�˾
 * </p>
 * <p>
 * ���ߣ�wuting
 * </p>
 * <p>
 * ����ʱ�䣺2016��12��15������11:17:06
 * </p>
 * <p>
 * �����ˣ�wuting
 * </p>
 * <p>
 * ���ţ�����Ժ��ȫ�ɿ��з����Ĳ�Ʒ�з���
 * </p>
 * <p>
 * �޸��ߣ�wuting
 * </p>
 * <p>
 * �޸�ʱ�䣺2016��12��15������11:17:06
 * </p>
 * <p>
 * �޸����ݣ�
 * </p>
 */
public class Fub {

    private static long startTime;

    private static long endTime;

    /**
     * ����˼�룺��1��1��2��3��5��8��13��21��34��������F(1)=1��F(2)=1,
     * F(n)=F(n-1)+F(n-2)��n>2��n��N*���ķ�ʽ���
     *
     * @param args
     */
    public static void main(String[] args) {
        startTime = System.nanoTime();
        System.out.println(fubDigui(6));
        endTime = System.nanoTime();
        System.out.println("�ݹ��㷨����ʱ��Ϊ��" + (endTime - startTime) + "ns");
        startTime = System.nanoTime();
        System.out.println(fubVarible(6));
        endTime = System.nanoTime();
        System.out.println("����forѭ���㷨����ʱ��Ϊ��" + (endTime - startTime) + "ns");
        startTime = System.nanoTime();
        System.out.println(fubArray(6));
        endTime = System.nanoTime();
        System.out.println("����forѭ���㷨����ʱ��Ϊ��" + (endTime - startTime) + "ns");
    }

    // �ݹ����쳲���������
    public static int fubDigui(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fubDigui(n - 1) + fubDigui(n - 2);
    }

    // ����forѭ����ʽ����쳲���������
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

    // ����forѭ����ʽ����쳲���������
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