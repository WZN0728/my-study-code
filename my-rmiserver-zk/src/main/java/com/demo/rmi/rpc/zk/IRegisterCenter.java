package com.demo.rmi.rpc.zk;

/**
 * @author wuting
 * @date 2019/03/21
 */
public interface IRegisterCenter {

    void register(String serviceName, String serviceAddrass);

}
