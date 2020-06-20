package com.study.demo.netty.dubbo.registry;

import com.study.demo.netty.dubbo.coreMsg.MsgCore;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wuting
 * @date 2019/02/26
 */
public class RpcRegistryHandler extends ChannelInboundHandlerAdapter {

    private static List<String> listCache = new ArrayList<String>();

    private static ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<String, Object>();

    public RpcRegistryHandler() {
        try {
            scanPackage("com.study.demo.netty.dubbo.provider");
            doRegister();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Object obj = new Object();
        MsgCore msgCore = (MsgCore) msg;
        if (concurrentHashMap.containsKey(msgCore.getClassName())) {
            Object clazz = concurrentHashMap.get(msgCore.getClassName());
            Method method = clazz.getClass().getMethod(msgCore.getMethodName(), msgCore.getParames());
            obj = method.invoke(clazz, msgCore.getValues());
        }
        ctx.writeAndFlush(obj);
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ctx.close();
    }

    //模仿IOC容器简单写一下
    public void scanPackage(String packageName) {
        URL url = this.getClass().getClassLoader().getResource(packageName.replaceAll("\\.", "/"));
        File dir = new File(url.getFile());
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                scanPackage(packageName + "." + file.getName());
            } else {
                listCache.add(packageName + "." + file.getName().replace(".class", "").trim());
            }
        }
    }

    //注册bean
    public void doRegister() throws Exception {
        if (listCache.size() == 0) {
            return;
        }
        for (String className : listCache) {
            Class<?> clazz = Class.forName(className);
            Class<?> interfaces = clazz.getInterfaces()[0];
            concurrentHashMap.put(interfaces.getName(), clazz.newInstance());
        }
    }

}
