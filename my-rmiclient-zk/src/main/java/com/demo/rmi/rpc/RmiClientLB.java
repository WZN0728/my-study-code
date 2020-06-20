package com.demo.rmi.rpc;

import com.demo.rmi.rpc.zk.IServiceDiscovery;
import com.demo.rmi.rpc.zk.ServiceDiscoveryImpl;
import com.demo.rmi.rpc.zk.ZkConfig;

/**
 * @author wuting
 * @date 2019/03/20
 */
public class RmiClientLB {

    public static void main(String[] args) {
        //负载均衡不带version的演示
        IServiceDiscovery iServiceDiscovery = new ServiceDiscoveryImpl(ZkConfig.ZK_CONNCTION_ADDRESS);
        RpcClientProxy rpcClientProxy = new RpcClientProxy(iServiceDiscovery);
        for (int i = 0; i < 10; i++) {
            RmiService rmiService = rpcClientProxy.clientProxy(RmiService.class, null);
            String result = rmiService.sayHi("wangwu" + i);
            System.out.println(result);
        }
    }

}
