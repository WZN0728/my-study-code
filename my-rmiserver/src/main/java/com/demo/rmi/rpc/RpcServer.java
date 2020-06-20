package com.demo.rmi.rpc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wuting
 * @date 2019/03/20
 */
public class RpcServer {

    private ExecutorService executorService = Executors.newCachedThreadPool();

    public void publish(final Object service, int port) {
        ServerSocket serverSocket = null;
        try {
            System.out.println("服务已启动");
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.execute(new ProcessHandler(service, socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
