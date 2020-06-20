package com.test.mode;

/**
 * @author wuting
 * @date 2019/02/14
 */
public class CreditCard extends Card {

    @Override
    protected String getType() {
        return "credit";
    }

    @Override
    protected void executeTransaction(int cents) {
        System.out.printf("credit卡 执行支付:%s",cents);
    }

}
