package com.demo.rmi.rpc;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wuting
 * @date 2019/03/20
 */
public class ProcessHandler implements Runnable {

    private Socket socket;

    private ConcurrentHashMap<String, Object> concurrentHashMap;

    public ProcessHandler(ConcurrentHashMap concurrentHashMap, Socket socket) {
        this.socket = socket;
        this.concurrentHashMap = concurrentHashMap;
    }

    @Override
    public void run() {
        //处理socket请求
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            //反序列化
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            RpcRequest rpcRequest = (RpcRequest) objectInputStream.readObject();
            Object result = invoke(rpcRequest);
            //序列化
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);
            objectOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

    private Object invoke(RpcRequest rpcRequest) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object[] args = rpcRequest.getParameters();
        Class<?>[] parameterTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            parameterTypes[i] = args[i].getClass();
        }
        String serviceName = rpcRequest.getClassName();
        String version = rpcRequest.getVersion();
        if (!StringUtils.isEmpty(version)) {
            serviceName = serviceName + "-" + version;
        }
        Object service = concurrentHashMap.get(serviceName);
        Method method = service.getClass().getMethod(rpcRequest.getMethodName(), parameterTypes);
        return method.invoke(service, args);
    }

}
