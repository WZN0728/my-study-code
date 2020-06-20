package com.study.demo.exception;

/**
 * @author wuting
 * @date 2019/02/15
 */
public class ExceptionDemo {

    //java.lang.Throwable属于异常的顶级父类
    //它的下面有两个子类,分别是---> Error & Exception
    //Error属于硬件或者底层级别的错误
    //exception属于程序逻辑上的错误 exception ---> unecheck exception(非受检异常) & check exception(受检异常)
    //受检异常与非受检异常的差别
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        try {
            int i = 0;
            int j = 1;
            i = j / i;
        } catch (Exception e) {
            e.printStackTrace();
            //RuntimeException属于非受检异常，外层方法可以捕获也可以忽略
            throw new RuntimeException("ecxeption");
        }
    }

}
