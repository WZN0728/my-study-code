package com.demo.rmi.rpc;

import com.demo.rmi.rpc.anno.RpcAnnotation;

/**
 * @author wuting
 * @date 2019/03/19
 */
@RpcAnnotation(value = RmiService.class)
public class RmiServiceImpl implements RmiService {

    @Override
    public String sayHi(String value) {
        return "Hi~," + value;
    }

}
