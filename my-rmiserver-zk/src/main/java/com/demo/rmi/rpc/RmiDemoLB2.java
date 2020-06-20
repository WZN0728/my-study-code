package com.demo.rmi.rpc;

import com.demo.rmi.rpc.zk.IRegisterCenter;
import com.demo.rmi.rpc.zk.RegisterCenterImpl;

/**
 * @author wuting
 * @date 2019/03/20
 */
public class RmiDemoLB2 {

    public static void main(String[] args) throws Exception {
        //通过不同的port区分
        RmiService rmiService = new RmiServiceLBImpl2();
        IRegisterCenter registerCenter = new RegisterCenterImpl();
        RpcServer rpcServer = new RpcServer(registerCenter, "127.0.0.1:6666");
        rpcServer.bind(rmiService);
        rpcServer.publish();
        System.in.read();
    }

}
