package com.demo.rmi.rpc.balance;

import java.util.List;
import java.util.Random;

/**
 * @author wuting
 * @date 2019/03/21
 */
public class RandomLoadBalance extends AbstractLoadBalance {

    @Override
    protected String doSelect(List<String> response) {
        int len = response.size();
        Random random = new Random();
        return response.get(random.nextInt(len));
    }

}
