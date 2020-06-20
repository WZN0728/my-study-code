package com.study.demo.mode.strategy;

/**
 * All rights Reserved, Designed By MyCompany
 *
 * @version V1.0
 * @Package com.test.mode
 * @Description: 策略模式demo
 * @author: 吴停
 * @Copyright: 2019/2/14 11:06 All rights reserved.
 */
public interface PaymentMethod {

    String pay(int cents);

}
