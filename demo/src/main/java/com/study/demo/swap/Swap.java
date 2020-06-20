package com.study.demo.swap;

import java.lang.reflect.Field;

/**
 * @author wuting
 * @date 2019/02/13
 */
public class Swap {

    //传值:1.引用传递2.值传递 而Integer传递的是副本
    public static void main(String[] args) throws Exception {
        Integer i1 = 1, i2 = 2;
        swap(i1, i2);
        System.out.printf("main i1 = %s,i2 = %s", i1, i2);
    }

    private static void swap(Integer i1, Integer i2) throws NoSuchFieldException, IllegalAccessException {
        //自动装箱,拆箱
        Integer temp = i1;
        i1 = i2;
        i2 = temp;
        System.out.printf("swap i1 = %s,i2 = %s", i1, i2);
        System.out.println();
        //因为Integer包装类传递的是引用的副本，不可能从上面的代码进行值的置换
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        int tmp = i1;
        field.setInt(i1, i2);
        field.setInt(i2, tmp);
        System.out.printf("swap i1 = %s,i2 = %s", i1, i2);
        System.out.println();
    }

}
