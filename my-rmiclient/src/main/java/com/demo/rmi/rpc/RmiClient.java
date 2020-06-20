package com.demo.rmi.rpc;

/**
 * @author wuting
 * @date 2019/03/20
 */
public class RmiClient {

    public static void main(String[] args) {
        RpcClientProxy rpcClientProxy = new RpcClientProxy();
        RmiService rmiService = rpcClientProxy.clientProxy(RmiService.class, "localhost", 6666);
        String result = rmiService.sayHi("wangwu");
        System.out.println(result);
    }

}
