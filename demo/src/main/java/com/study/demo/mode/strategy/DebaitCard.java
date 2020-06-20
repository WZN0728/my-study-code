package com.study.demo.mode.strategy;

import org.springframework.stereotype.Service;

/**
 * @author wuting
 * @date 2019/02/14
 */
@Service
public class DebaitCard extends Card {

    @Override
    protected String getType() {
        return "debait";
    }

    @Override
    protected String executeTransaction(int cents) {
        System.out.printf("debait卡 执行支付:%s", cents);
        return "支付成功";
    }

}
