package com.study.demo.netty.dubbo.api;

/**
 * @author wuting
 * @date 2019/02/26
 */
public interface IRpcCalculator {

    Integer add(int a, int b);

    Integer sub(int a, int b);

    Integer multiply(int a, int b);

    Integer division(int a, int b);

}
