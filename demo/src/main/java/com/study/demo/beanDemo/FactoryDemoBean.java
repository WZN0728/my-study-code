package com.study.demo.beanDemo;

/**
 * @author wuting
 * @date 2019/02/15
 */
public class FactoryDemoBean {

    //工厂方式注入
    private static DemoBean getInstance() {
        return new DemoBean();
    }

}
