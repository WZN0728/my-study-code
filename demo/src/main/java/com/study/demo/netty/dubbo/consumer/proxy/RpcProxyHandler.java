package com.study.demo.netty.dubbo.consumer.proxy;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author wuting
 * @date 2019/02/26
 */
public class RpcProxyHandler extends ChannelInboundHandlerAdapter {

    private Object result;

    public Object getResult() {
        return this.result;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        this.result = msg;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

}
