package com.demo.rmi.rpc.balance;

import java.util.List;

/**
 * @author wuting
 * @date 2019/03/21
 */
public abstract class AbstractLoadBalance implements LoadBalance {

    @Override
    public String selectHost(List<String> response) {
        if (null == response || response.size() == 0) {
            return null;
        }
        if (response.size() == 1) {
            return response.get(0);
        }
        return doSelect(response);
    }

    protected abstract String doSelect(List<String> response);

}
