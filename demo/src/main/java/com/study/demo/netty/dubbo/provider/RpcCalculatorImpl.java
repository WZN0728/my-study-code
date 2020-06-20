package com.study.demo.netty.dubbo.provider;

import com.study.demo.netty.dubbo.api.IRpcCalculator;

/**
 * @author wuting
 * @date 2019/02/26
 */
public class RpcCalculatorImpl implements IRpcCalculator {

    @Override
    public Integer add(int a, int b) {
        return a + b;
    }

    @Override
    public Integer sub(int a, int b) {
        return a - b;
    }

    @Override
    public Integer multiply(int a, int b) {
        return a * b;
    }

    @Override
    public Integer division(int a, int b) {
        return a / b;
    }

}
