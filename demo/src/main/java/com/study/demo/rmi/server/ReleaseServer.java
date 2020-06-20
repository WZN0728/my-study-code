package com.study.demo.rmi.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author wuting
 * @date 2019/03/19
 */
public class ReleaseServer {

    private int port;

    public ReleaseServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        //端口号默认1099
        ReleaseServer releaseServer = new ReleaseServer(1099);
        releaseServer.init();
    }

    public void init() throws RemoteException, MalformedURLException {
        RmiService rmiService = new RmiServiceImpl();
        LocateRegistry.createRegistry(port);
        Naming.rebind("rmi://127.0.0.1/rmiService", rmiService);
        System.out.println("服务启动成功!!!");
    }

}
