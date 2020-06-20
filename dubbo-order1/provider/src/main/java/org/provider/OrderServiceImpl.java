/**
 * All rights Reserved, Designed By MyCompany
 *
 * @Title: OrderServiceImpl.java
 * @Package org.provider
 * @Copyright: 2018 All rights reserved.
 */
package org.provider;

import org.api.DoOrderRequest;
import org.api.DoOrderResponse;
import org.api.IOrderService;
import org.springframework.stereotype.Service;

/**
 * @ClassName: OrderServiceImpl
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月17日 上午11:50:14
 */
@Service("orderService1")
public class OrderServiceImpl implements IOrderService {

    public DoOrderResponse doOrder(DoOrderRequest doOrderRequest) {
        DoOrderResponse doOrderResponse = new DoOrderResponse();
        doOrderResponse.setName(doOrderRequest.getName());
        doOrderResponse.setCode("版本1    ->       00011    ->     负载均衡");
        doOrderResponse.setData("版本1    ->       已到货    ->     负载均衡");
        System.out.println("版本1    ->       订单已签收:" + doOrderResponse.getName() + "  ->   " + doOrderResponse.getCode() + "    ->     负载均衡"
                + doOrderResponse.getData());
        return doOrderResponse;
    }

}
