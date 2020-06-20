package com.study.demo.clone;

import java.io.*;

/**
 * @author wuting
 * @date 2019/02/14
 */
public class User implements Cloneable, Serializable {

    private String name;

    private Email email;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email=" + email +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //在这里针对引用类型进行深度的克隆
        User user = (User) super.clone();
        user.setEmail((Email) email.clone());
        return user;
    }

    public User deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return (User) objectInputStream.readObject();
    }

}
