package com.study.demo.mode.strategy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wuting
 * @date 2019/02/14
 */
@Controller
public class StrategyDemo {

    @RequestMapping(value = "/pay")
    public String payReq(@RequestParam String payType) {
        Bill bill = new Bill();
        bill.addItem(new Item("JVM书籍", 50));
        bill.addItem(new Item("java四大名著", 88));
        //bill.pay(PaymentMethodFactory.getPaymentMethod("debait"));
        return bill.pay(Card.payConstructorMap.get(payType));
    }

    public static void main(String[] args) {
        Bill bill = new Bill();
        bill.addItem(new Item("JVM书籍", 50));
        bill.addItem(new Item("java四大名著", 88));
        //bill.pay(PaymentMethodFactory.getPaymentMethod("debait"));
        bill.pay(Card.payConstructorMap.get("credit"));
    }

}
