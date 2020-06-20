package com.demo.rmi.rpc;

import com.demo.rmi.rpc.anno.RpcAnnotation;

/**
 * @author wuting
 * @date 2019/03/19
 */
@RpcAnnotation(value = RmiService.class, version = "2.0")
public class RmiServiceImpl2 implements RmiService {

    @Override
    public String sayHi(String value) {
        return "Hi~,version = \"2.0\" " + value;
    }

}
