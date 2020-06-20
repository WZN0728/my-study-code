package com.study.demo.clone;

import java.io.IOException;

/**
 * @author wuting
 * @date 2019/02/14
 */
public class CloneDemo implements Cloneable {//Cloneable是一个标识，如果没有就会报错java.lang.CloneNotSupportedException

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CloneDemo{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        /*CloneDemo cloneDemo = new CloneDemo();
        cloneDemo.setName("zhangsan");
        //再调用cloneDemo.clone()时如果没有Cloneable就会报错
        CloneDemo cloneDemo1 = (CloneDemo) cloneDemo.clone();
        System.out.println(cloneDemo);*/
        //init();
        initDeepClone();
    }

    //浅克隆，实现方式就是implement Clonable,重写Object超类里边的clone方法
    public static void init() throws CloneNotSupportedException {
        Email email = new Email();
        email.setContent("你好,zhangsan");
        User user = new User("zhangsan");
        user.setEmail(email);
        User user1 = (User) user.clone();
        user1.setName("lisi");
        //1.基本类型2.引用类型
        //引用再浅克隆中是无法正确的修改，因为引用是无法浅克隆的，只有基本类型可以浅克隆
        email.setContent("你好,lisi");
        user1.setEmail(email);
        System.out.printf("姓名:%s,邮件内容:%s%n", user.getName(), user.getEmail().getContent());
        System.out.printf("姓名:%s,邮件内容:%s%n", user1.getName(), user1.getEmail().getContent());
    }

    //深克隆实现方式就是implement Serilazible,再方法中自定义deepClone方法，方法中就是通过序列化的方式重新new对象
    public static void initDeepClone() throws IOException, ClassNotFoundException {
        Email email = new Email();
        email.setContent("你好,zhangsan");
        User user = new User("zhangsan");
        user.setEmail(email);
        User user1 = user.deepClone();
        user1.setName("lisi");
        user1.getEmail().setContent("你好,lisi");
        System.out.printf("姓名:%s,邮件内容:%s%n", user.getName(), user.getEmail().getContent());
        System.out.printf("姓名:%s,邮件内容:%s%n", user1.getName(), user1.getEmail().getContent());
    }

}
