package com.study.demo.netty.dubbo.registry;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * @author wuting
 * @date 2019/02/26
 */
public class RpcRegistry {

    private int port;

    public RpcRegistry(int port) {
        this.port = port;
    }

    public void init() {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        EventLoopGroup masterGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(masterGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline channelPipeline = ch.pipeline();
                            //TCP拆包、粘包的编、解码器
                            channelPipeline.addLast("registryDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                            channelPipeline.addLast("registryEncoder", new LengthFieldPrepender(4));
                            //jdk默认的序列化方式处理序列化的编、解码器
                            channelPipeline.addLast("encoder", new ObjectEncoder());
                            channelPipeline.addLast("decoder", new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
                            //自己的业务逻辑
                            channelPipeline.addLast(new RpcRegistryHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture channelFuture = serverBootstrap.bind(this.port).sync();
            System.out.println("dubbo 注册中心开始监听注册信息:" + this.port);
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            workerGroup.shutdownGracefully();
            masterGroup.shutdownGracefully();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new RpcRegistry(8080).init();
    }

}
