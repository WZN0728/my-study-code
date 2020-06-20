package com.demo.rmi.rpc.balance;

import java.util.List;

public interface LoadBalance {

    String selectHost(List<String> response);

}
