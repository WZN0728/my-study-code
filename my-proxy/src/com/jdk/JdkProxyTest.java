package com.jdk;

import com.jdk.dynamic.JDKDynamicProxyDemo;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;

public class JdkProxyTest {

    public static void main(String[] args) {
        //jdk�ķ�ʽ��ʵ�ֶ�̬����
        Person person = (Person) new Lianjia().getInstance(new Owner());
        person.findHouse();
        //ASM��̬�ֽ���ķ�ʽʵ�ֶ�̬����
        //init();
    }

    public static void init() {
        JDKDynamicProxyDemo dynamicProxyDemo = new JDKDynamicProxyDemo();
        Person person = (Person) new Wawj();
        Person person1 = (Person) dynamicProxyDemo.bind(person);
        System.out.println(person1.findHouse());
        byte[] proxyFileClass = ProxyGenerator.generateProxyClass("$Proxy0", Wawj.class.getInterfaces());
        String path = "ZjProxy.class";
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(path))) {
            fileOutputStream.write(proxyFileClass);
            fileOutputStream.flush();
            System.out.println("success");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

}