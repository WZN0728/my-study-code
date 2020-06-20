package com.study.demo.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author wuting
 * @date 2019/03/19
 */
public class RmiServiceImpl extends UnicastRemoteObject implements RmiService {

    protected RmiServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHi(String value) throws RemoteException {
        return "Hi~," + value;
    }

}
