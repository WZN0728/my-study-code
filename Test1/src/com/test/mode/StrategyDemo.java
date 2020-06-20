package com.test.mode;

/**
 * @author wuting
 * @date 2019/02/14
 */
public class StrategyDemo {

    public static void main(String[] args) {
        Bill bill = new Bill();
        bill.addItem(new Item("JVM书籍",50));
        bill.addItem(new Item("java四大名著",88));
        bill.pay(PaymentMethodFactory.getPaymentMethod("debait"));
    }

}
