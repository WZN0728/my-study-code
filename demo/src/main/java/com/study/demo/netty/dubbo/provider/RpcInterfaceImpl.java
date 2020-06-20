package com.study.demo.netty.dubbo.provider;

import com.study.demo.netty.dubbo.api.RpcInterface;

/**
 * @author wuting
 * @date 2019/02/26
 */
public class RpcInterfaceImpl implements RpcInterface {

    @Override
    public String getValue(String name) {
        return "你好:" + name;
    }

}
