package com.demo.rmi.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author wuting
 * @date 2019/03/20
 */
public class TCPTransport {


    private int port;

    private String host;

    public TCPTransport(String host, int port) {
        this.port = port;
        this.host = host;
    }

    private Socket newSocket() {
        System.out.println("创建一个socket连接");
        Socket socket = null;
        try {
            socket = new Socket(host, port);
            return socket;
        } catch (IOException e) {
            throw new RuntimeException("创建连接失败!!!");
        }
    }

    public Object send(RpcRequest rpcRequest) {
        Socket socket = null;
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            socket = newSocket();
            //序列化向外写
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(rpcRequest);
            objectOutputStream.flush();
            //反序列化读取结果
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object result = objectInputStream.readObject();
            return result;
        } catch (Exception e) {
            throw new RuntimeException("send exception!!!" + e.getMessage());
        } finally {
            if (null != socket) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != objectInputStream) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != objectOutputStream) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
