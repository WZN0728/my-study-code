/**
 * All rights Reserved, Designed By MyCompany
 *
 * @Title: OrderServiceImpl2.java
 * @Package org.provider
 * @Copyright: 2018 All rights reserved.
 */
package org.provider;

import org.api.DoOrderRequest;
import org.api.DoOrderResponse;
import org.api.IOrderService;
import org.springframework.stereotype.Service;

/**
 * @ClassName: OrderServiceImpl2
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月17日 下午10:54:10
 */
@Service("orderService2")
public class OrderServiceImpl2 implements IOrderService {

    public DoOrderResponse doOrder(DoOrderRequest doOrderRequest) {
        DoOrderResponse doOrderResponse = null;
        try {
            Thread.sleep(5000);
            doOrderResponse = new DoOrderResponse();
            doOrderResponse.setName(doOrderRequest.getName());
            doOrderResponse.setCode("版本2    ->       0001");
            doOrderResponse.setData("版本2    ->       已到货");
            System.out.println("版本2    ->       订单已签收:" + doOrderResponse.getName() + "  ->   "
                    + doOrderResponse.getCode() + "   ->   " + doOrderResponse.getData());
        } catch (Exception e) {
            // TODO: handle exception
        }
        return doOrderResponse;
    }

}
