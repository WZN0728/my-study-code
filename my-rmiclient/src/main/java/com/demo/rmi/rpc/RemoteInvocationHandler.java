package com.demo.rmi.rpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wuting
 * @date 2019/03/20
 */
public class RemoteInvocationHandler implements InvocationHandler {

    private int port;

    private String host;

    public RemoteInvocationHandler(String host, int port) {
        this.port = port;
        this.host = host;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParameters(args);
        TCPTransport tcpTransport = new TCPTransport(this.host, this.port);
        return tcpTransport.send(rpcRequest);
    }

}
