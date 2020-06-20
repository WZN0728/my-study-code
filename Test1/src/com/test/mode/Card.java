package com.test.mode;

/**
 * @author wuting
 * @date 2019/02/14
 */
public abstract class Card implements PaymentMethod {


    @Override
    public void pay(int cents) {
        System.out.printf("use : %s, 支付了: %s", getType(), cents);
        //具体执行支付方法
        executeTransaction(cents);
    }

    protected abstract String getType();

    protected abstract void executeTransaction(int cents);

}
