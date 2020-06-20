package com.study.demo.netty.dubbo.consumer;

import com.study.demo.netty.dubbo.api.IRpcCalculator;
import com.study.demo.netty.dubbo.api.RpcInterface;
import com.study.demo.netty.dubbo.consumer.proxy.RpcProxy;

/**
 * @author wuting
 * @date 2019/02/26
 */
public class RpcConsumer {

    public static void main(String[] args) {
        RpcInterface rpcInterface = RpcProxy.create(RpcInterface.class);
        String value = rpcInterface.getValue("zhangsan");
        System.out.println(value);
        IRpcCalculator iRpcCalculator = RpcProxy.create(IRpcCalculator.class);
        int a = 10, b = 8;
        System.out.println(a + "+" + b + "=" + iRpcCalculator.add(a, b));
        System.out.println(a + "-" + b + "=" + iRpcCalculator.sub(a, b));
        System.out.println(a + "*" + b + "=" + iRpcCalculator.multiply(a, b));
        System.out.println(a + "/" + b + "=" + iRpcCalculator.division(a, b));
    }

}
