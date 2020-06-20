package com.study.demo.seril;

import sun.misc.ProxyGenerator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author wuting
 * @date 2019/02/14
 */
public class User implements Serializable {

    //序列化时相当于对象的指纹(类名,属性名等的64位hash值)
    private static final long serialVersionUID = 2956605390231861819L;

    private String id;

    //transient关键字防止对象的属性序列化
    private transient String name;

    //writeObject与readObject方法是绕过(transient关键字)
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(name);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        name = (String) objectInputStream.readObject();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
