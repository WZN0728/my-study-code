package com.study.demo.io.nio.demo;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author wuting
 * @date 2019/02/23
 */
public class demo {

    private int port;

    private Selector selector;

    private InetSocketAddress inetSocketAddress = null;

    public demo(int port) {
        this.port = port;
        try {
            inetSocketAddress = new InetSocketAddress(this.port);
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(inetSocketAddress);
            serverSocketChannel.configureBlocking(false);
            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("server端开启服务,端口:" + this.port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new demo(8080).listener();
    }

    private void listener() {
        try {
            while (true) {
                int wait = this.selector.select();
                if (wait == 0) {
                    continue;
                }
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();
                if (selectionKeyIterator.hasNext()) {
                    SelectionKey selectionKey = selectionKeyIterator.next();
                    process(selectionKey);
                    selectionKeyIterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void process(SelectionKey selectionKey) throws Exception {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        ServerSocketChannel serverSocketChannel;
        SocketChannel socketChannel;
        if (selectionKey.isAcceptable()) {
            serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
            socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
        } else if (selectionKey.isReadable()) {
            socketChannel = (SocketChannel) selectionKey.channel();
            int len = 0;
            while ((len = socketChannel.read(byteBuffer)) != -1) {
                byteBuffer.flip();
                String content = new String(byteBuffer.array(), 0, len);
                System.out.println("结果:" + content);
                socketChannel.register(selector, SelectionKey.OP_READ);
            }
        } else if (selectionKey.isWritable()) {
            socketChannel = (SocketChannel) selectionKey.channel();
            socketChannel.write(byteBuffer);
            socketChannel.close();
        }
    }

}
