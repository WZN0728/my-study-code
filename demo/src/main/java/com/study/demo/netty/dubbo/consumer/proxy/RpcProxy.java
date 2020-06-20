package com.study.demo.netty.dubbo.consumer.proxy;

import com.study.demo.netty.dubbo.coreMsg.MsgCore;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wuting
 * @date 2019/02/26
 */
public class RpcProxy {

    public static <T> T create(Class<?> clazz) {
        MethodProxy methodProxy = new MethodProxy(clazz);
        T result = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, methodProxy);
        return result;
    }

}

class MethodProxy implements InvocationHandler {

    private Class<?> clazz;

    public MethodProxy(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //如果传进来的是一个具体的类,直接忽略
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        } else {
            //如果传进来的是一个接口,则使用远程调用(核心)
            return invokeRpc(method, args);
        }
    }

    public Object invokeRpc(Method method, Object[] args) throws InterruptedException {
        MsgCore msgCore = new MsgCore();
        msgCore.setClassName(this.clazz.getName());
        msgCore.setMethodName(method.getName());
        msgCore.setParames(method.getParameterTypes());
        msgCore.setValues(args);
        final RpcProxyHandler rpcProxyHandler = new RpcProxyHandler();
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        try {
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline channelPipeline = ch.pipeline();
                            //拆包、粘包的编、解码器
                            channelPipeline.addLast("consumerDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                            channelPipeline.addLast("consumerEncoder", new LengthFieldPrepender(4));
                            //jdk默认的序列化方式处理序列化的编、解码器
                            channelPipeline.addLast("encoder", new ObjectEncoder());
                            channelPipeline.addLast("decoder", new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
                            //自己的业务逻辑
                            channelPipeline.addLast(rpcProxyHandler);
                        }
                    });
            ChannelFuture channelFuture = bootstrap.connect("localhost", 8080).sync();
            channelFuture.channel().writeAndFlush(msgCore).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
        return rpcProxyHandler.getResult();
    }

}
