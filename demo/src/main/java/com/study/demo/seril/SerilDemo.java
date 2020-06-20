package com.study.demo.seril;

import java.io.*;

/**
 * @author wuting
 * @date 2019/02/14
 */
public class SerilDemo {

    //序列化协议(Java原生序列化,json,xml(webservice),hessian,protobuf,avro,kyro)
    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setId("111111111");
        user.setName("zhangsan");
        //ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File("user"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user);
        FileInputStream fileInputStream = new FileInputStream(new File("user"));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        User user1 = (User) objectInputStream.readObject();
        System.out.println(user1);
    }

}
