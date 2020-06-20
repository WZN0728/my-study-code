package com.test.mode;

/**
 * @author wuting
 * @date 2019/02/14
 */
public class PaymentMethodFactory {

    public static PaymentMethod getPaymentMethod(String type){
        switch (type) {
            case "credit":
                return new CreditCard();
            case "debait":
                return new DebaitCard();
            default:
                throw new RuntimeException("不支持当前卡支付");
        }
    }

}
