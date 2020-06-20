package com.study.demo.mode.strategy;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wuting
 * @date 2019/02/14
 */
public abstract class Card implements PaymentMethod {

    static Map<String, PaymentMethod> payConstructorMap = new ConcurrentHashMap<String, PaymentMethod>();

    @PostConstruct
    public void init() {
        payConstructorMap.put(getType(), this);
    }

    @Override
    public String pay(int cents) {
        System.out.printf("use : %s, 支付了: %s%n", getType(), cents);
        //具体执行支付方法
        return executeTransaction(cents);
    }

    protected abstract String getType();

    protected abstract String executeTransaction(int cents);

}
