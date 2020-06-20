package com.study.demo.rmi.client;

import com.study.demo.rmi.server.RmiService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author wuting
 * @date 2019/03/19
 */
public class InvokeRmiServer {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        RmiService rmiService = (RmiService) Naming.lookup("rmi://127.0.0.1/rmiService");
        String result = rmiService.sayHi("lisi");
        System.out.println(result);
    }

}
