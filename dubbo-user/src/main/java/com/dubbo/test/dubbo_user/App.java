package com.dubbo.test.dubbo_user;

import java.util.concurrent.Future;

import org.api.DoOrderRequest;
import org.api.DoOrderResponse;
import org.api.IOrderQueryService;
import org.api.IOrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.RpcContext;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("order-consumer.xml");
        IOrderService iOrderService = (IOrderService) context.getBean("orderServices");
        for (int i = 0; i < 10; i++) {
            DoOrderRequest doOrderRequest = new DoOrderRequest();
            doOrderRequest.setName("一双aj12");
            DoOrderResponse result = iOrderService.doOrder(doOrderRequest);
            System.out.println(result);
        }
        System.out.println("success");

        /**
         * 同步调用
         */
        IOrderQueryService iOrderQueryService = (IOrderQueryService) context.getBean("orderQueryServices");
        System.out.println(iOrderQueryService.queryOrder("Hello World!!!"));
        /**
         * 异步调用
         */
        System.out.println("-------------这里是异步调用-------------------");
        Future<Object> future = RpcContext.getContext().getFuture();
        System.out.println("已经调用服务端了");
        System.out.println(future.get().toString());
    }

}
