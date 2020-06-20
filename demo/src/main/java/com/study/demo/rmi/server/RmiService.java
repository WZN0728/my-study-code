package com.study.demo.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author wuting
 * @date 2019/03/19
 */
public interface RmiService extends Remote {

    String sayHi(String value) throws RemoteException;

}
