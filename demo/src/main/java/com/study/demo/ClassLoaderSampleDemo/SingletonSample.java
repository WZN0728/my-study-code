package com.study.demo.ClassLoaderSampleDemo;

/**
 * @author wuting
 * @date 2019/02/14
 */
public class SingletonSample {

    public static int count1;

    public static int count2 = 0;

    private static SingletonSample instance = new SingletonSample();

    private SingletonSample() {
        count1++;
        count2++;
        System.out.println("constructor");
    }

    static {
        System.out.println("static{}");
    }

    public static SingletonSample getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        SingletonSample.getInstance();
        System.out.printf("count1:%s%ncount2:%s%n", count1, count2);
    }

}
