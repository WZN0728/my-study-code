package com.demo.rmi.rpc;

import java.lang.reflect.Proxy;

/**
 * @author wuting
 * @date 2019/03/20
 */
public class RpcClientProxy {

    public <T> T clientProxy(final Class<?> interfaceCls, final String host, final int port) {
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class[]{interfaceCls}, new RemoteInvocationHandler(host, port));
    }

}
