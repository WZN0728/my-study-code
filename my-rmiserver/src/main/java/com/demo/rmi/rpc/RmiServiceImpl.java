package com.demo.rmi.rpc;

/**
 * @author wuting
 * @date 2019/03/19
 */
public class RmiServiceImpl implements RmiService {

    @Override
    public String sayHi(String value) {
        return "Hi~," + value;
    }

}
