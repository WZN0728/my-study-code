package com.demo.rmi.rpc;

import com.demo.rmi.rpc.zk.IRegisterCenter;
import com.demo.rmi.rpc.zk.RegisterCenterImpl;

/**
 * @author wuting
 * @date 2019/03/20
 */
public class RmiDemo {

    public static void main(String[] args) throws Exception {
        //通过不同的version区分
        RmiService rmiService = new RmiServiceImpl();
        RmiService rmiService2 = new RmiServiceImpl2();
        IRegisterCenter registerCenter = new RegisterCenterImpl();
        RpcServer rpcServer = new RpcServer(registerCenter, "127.0.0.1:8888");
        rpcServer.bind(rmiService,rmiService2);
        rpcServer.publish();
        System.in.read();
    }

}
