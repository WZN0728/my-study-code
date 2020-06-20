package com.demo.rmi.rpc;

import com.demo.rmi.rpc.anno.RpcAnnotation;
import com.demo.rmi.rpc.zk.IRegisterCenter;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wuting
 * @date 2019/03/20
 */
public class RpcServer {

    //注册中心
    private IRegisterCenter iRegisterCenter;

    //服务注册地址
    private String serverAddress;

    ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();

    public RpcServer(IRegisterCenter iRegisterCenter, String serverAddress) {
        this.iRegisterCenter = iRegisterCenter;
        this.serverAddress = serverAddress;
    }

    public void bind(Object... services) {
        for (Object service : services) {
            RpcAnnotation annotation = service.getClass().getAnnotation(RpcAnnotation.class);
            String serviceName = annotation.value().getName();
            String version = annotation.version();
            if (!StringUtils.isEmpty(version)) {
                serviceName = serviceName + "-" + version;
            }
            //将服务绑定,所谓的绑定其实就是绑定在服务端发布的服务的地址,说白了就是一个zk节点的路径
            concurrentHashMap.put(serviceName, service);
        }
    }

    private ExecutorService executorService = Executors.newCachedThreadPool();

    public void publish() {
        ServerSocket serverSocket = null;
        try {
            System.out.println("服务已启动");
            String[] addr = serverAddress.split(":");
            serverSocket = new ServerSocket(Integer.parseInt(addr[1]));
            for (String interfaceName : concurrentHashMap.keySet()) {
                iRegisterCenter.register(interfaceName, serverAddress);
                System.out.printf("服务注册成功:%s%n", interfaceName + "->" + serverAddress);
            }
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.execute(new ProcessHandler(concurrentHashMap, socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
