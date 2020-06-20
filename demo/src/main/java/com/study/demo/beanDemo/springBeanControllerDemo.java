package com.study.demo.beanDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wuting
 * @date 2019/02/15
 */
public class springBeanControllerDemo {

    //set方式注入
    private DemoBean demoBean;

    private DemoBean demoBean2;

    private DemoBean demoBeanFactory;

    public void setDemoBeanFactory(DemoBean demoBeanFactory) {
        this.demoBeanFactory = demoBeanFactory;
    }

    //构造方式注入
    public springBeanControllerDemo(DemoBean demoBean) {
        this.demoBean = demoBean;
    }

    public void setDemoBean(DemoBean demoBean) {
        this.demoBean = demoBean;
    }

    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("");
        //当scope为singleton时,bean就是一个单实例对象
        //当scope为prototype时,context.getBean("")每次返回的是new的一个对象
        context.getBean("");
    }

}
