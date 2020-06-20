package com.demo.rmi.rpc;

import com.demo.rmi.rpc.zk.IServiceDiscovery;

import java.lang.reflect.Proxy;

/**
 * @author wuting
 * @date 2019/03/20
 */
public class RpcClientProxy {

    private IServiceDiscovery iServiceDiscovery;

    public RpcClientProxy(IServiceDiscovery iServiceDiscovery) {
        this.iServiceDiscovery = iServiceDiscovery;
    }

    public <T> T clientProxy(final Class<?> interfaceCls,final String version) {
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class[]{interfaceCls}, new RemoteInvocationHandler(version,iServiceDiscovery));
    }

}
