package com.test.mode;

/**
 * @author wuting
 * @date 2019/02/14
 */
public class DebaitCard extends Card{

    @Override
    protected String getType() {
        return "debait";
    }

    @Override
    protected void executeTransaction(int cents) {
        System.out.printf("debait卡 执行支付:%s",cents);
    }

}
