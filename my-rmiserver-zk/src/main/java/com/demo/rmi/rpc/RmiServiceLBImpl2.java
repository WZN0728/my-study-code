package com.demo.rmi.rpc;

import com.demo.rmi.rpc.anno.RpcAnnotation;

/**
 * @author wuting
 * @date 2019/03/19
 */
@RpcAnnotation(value = RmiService.class)
public class RmiServiceLBImpl2 implements RmiService {

    /**
     * 负载均衡
     *
     * @param value
     * @return
     */
    @Override
    public String sayHi(String value) {
        return "Hi~,I am 6666 " + value;
    }

}
