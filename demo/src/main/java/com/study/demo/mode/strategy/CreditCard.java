package com.study.demo.mode.strategy;

import org.springframework.stereotype.Service;

/**
 * @author wuting
 * @date 2019/02/14
 */
@Service
public class CreditCard extends Card {

    @Override
    protected String getType() {
        return "credit";
    }

    @Override
    protected String executeTransaction(int cents) {
        System.out.printf("credit卡 执行支付:%s%n", cents);
        return "支付成功";
    }

}
