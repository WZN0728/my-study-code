package com.demo.rmi.rpc;

import java.rmi.RemoteException;

/**
 * @author wuting
 * @date 2019/03/20
 */
public class RmiDemo {

    public static void main(String[] args) throws RemoteException {
        RmiService rmiService = new RmiServiceImpl();
        RpcServer rpcServer = new RpcServer();
        rpcServer.publish(rmiService, 6666);
    }

}
