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
public class OwenrNIOServer {

    private int port = 8080;

    private Selector selector;

    private static InetSocketAddress inetSocketAddress = null;

    public OwenrNIOServer(int port) {
        try {
            this.port = port;
            inetSocketAddress = new InetSocketAddress(port);
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(inetSocketAddress);
            //设置为非阻塞,默认为阻塞
            serverSocketChannel.configureBlocking(false);
            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.printf("服务准备就绪,监听的端口是:%s%n", port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new OwenrNIOServer(8080).listener();
    }

    private void listener() {
        try {
            while (true) {
                int wait = this.selector.select();
                if (wait == 0) {
                    continue;
                }
                Set<SelectionKey> selectionKeys = this.selector.selectedKeys();
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
        // allocate分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //ByteBuffer ShortBuffer IntBuffer LongBuffer FloatBuffer DoubleBuffer CharBuffer ---> Buffer
        //ByteBuffer.wrap(new byte[1024]);//buffer的方法
        //--------------buffer的缓冲区分配,每种缓冲区都有自己的特点----------------------------------------
        //byteBuffer.slice();//缓冲区分片,调用 slice()方法可以创建一个子缓冲区，
        //byteBuffer.asReadOnlyBuffer();//只读缓冲区,这个方法返回一个与原缓冲区完,全相同的缓冲区，并与原缓冲区共享数据，只不过它是只读的。如果原缓冲区的内容发生了变化，只读缓冲区的内容也随之发生变化
        //ByteBuffer.allocateDirect(1024);//直接缓冲区,内存零拷贝,直接调用系统底层的内存
        //MappedByteBuffer mbb = fc.map( FileChannel.MapMode.READ_WRITE,start, size );//内存映射文件I/O
        SocketChannel socketChannel;
        if (selectionKey.isAcceptable()) {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
            socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
        } else if (selectionKey.isReadable()) {
            socketChannel = (SocketChannel) selectionKey.channel();
            int len = 0;
            while ((len = socketChannel.read(byteBuffer)) != -1) {
                // 重设此缓冲区，将限制设置为当前位置，然后将当前位置设置为 0
                //1. 把 limit 设置为当前的 position 值
                //2. 把 position 设置为 0
                //limit = position;
                //position = 0;
                //mark = -1;
                //0 <= position <= limit <= capacity
                byteBuffer.flip();
                String value = new String(byteBuffer.array(), 0, len);
                System.out.println("结果:" + value);
                socketChannel.register(selector, SelectionKey.OP_WRITE);
            }
            byteBuffer.clear();
        } else if (selectionKey.isWritable()) {
            socketChannel = (SocketChannel) selectionKey.channel();
            socketChannel.write(byteBuffer);
            socketChannel.close();
        }
    }

}
