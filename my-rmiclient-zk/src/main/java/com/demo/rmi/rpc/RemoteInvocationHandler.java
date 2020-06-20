package com.demo.rmi.rpc;

import com.demo.rmi.rpc.zk.IServiceDiscovery;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wuting
 * @date 2019/03/20
 */
public class RemoteInvocationHandler implements InvocationHandler {

    private String version;

    private IServiceDiscovery iServiceDiscovery;

    public RemoteInvocationHandler(String version, IServiceDiscovery iServiceDiscovery) {
        this.version = version;
        this.iServiceDiscovery = iServiceDiscovery;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParameters(args);
        rpcRequest.setVersion(version);
        //根据接口名称得到对应的服务地址
        String serviceAddress = iServiceDiscovery.discovery(rpcRequest.getClassName());
        TCPTransport tcpTransport = new TCPTransport(serviceAddress);
        return tcpTransport.send(rpcRequest);
    }

}
