package com.study.demo.rmi;

/**
 * @author wuting
 * @date 2019/03/19
 */
public class RmiInvoke {

    public static void main(String[] args) {
        RmiService rmiService = new RmiServiceImpl();
        String reuslt = rmiService.sayHi("zhangsan");
        System.out.println(reuslt);
    }

}
