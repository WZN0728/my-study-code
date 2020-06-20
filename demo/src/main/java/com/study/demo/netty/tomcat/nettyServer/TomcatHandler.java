package com.study.demo.netty.tomcat.nettyServer;

import com.study.demo.netty.tomcat.http.MyHttpRequest;
import com.study.demo.netty.tomcat.http.MyHttpResponse;
import com.study.demo.netty.tomcat.http.MyServlet;
import com.study.demo.util.CustomConfig;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpRequest;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author wuting
 * @date 2019/02/24
 */
public class TomcatHandler extends ChannelInboundHandlerAdapter {

    private Logger LOG = Logger.getLogger(getClass());

    private static final Map<Pattern, Class<?>> servletMapping = new HashMap<Pattern, Class<?>>();

    static {
        CustomConfig.load("web.properties");
        for (String key : CustomConfig.getKeys()) {
            if (key.startsWith("servlet")) {
                String name = key.replaceFirst("servlet.", "");
                if (name.indexOf(".") != -1) {
                    name = name.substring(0, name.indexOf("."));
                } else {
                    continue;
                }
                String pattern = CustomConfig.getString("servlet." + name + ".urlPattern");
                pattern = pattern.replaceAll("\\*", ".*");
                String className = CustomConfig.getString("servlet." + name + ".className");
                if (!servletMapping.containsKey(pattern)) {
                    try {
                        servletMapping.put(Pattern.compile(pattern), Class.forName(className));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest) msg;
            MyHttpRequest myHttpRequest = new MyHttpRequest(ctx, httpRequest);
            MyHttpResponse myHttpResponse = new MyHttpResponse(ctx, httpRequest);
            String uri = myHttpRequest.getUri();
            String method = myHttpRequest.getMethod();
            LOG.info(String.format("%nuri:%s%nmethod:%s%n", uri, method));
            Boolean flag = false;
            for (Map.Entry<Pattern, Class<?>> entry : servletMapping.entrySet()) {
                if (entry.getKey().matcher(uri).matches()) {
                    flag = true;
                    MyServlet myServlet = (MyServlet) entry.getValue().newInstance();
                    if ("get".equalsIgnoreCase(method)) {
                        myServlet.doGet(myHttpRequest, myHttpResponse);
                    } else {
                        myServlet.doPost(myHttpRequest, myHttpResponse);
                    }
                }
            }
            if (!flag) {
                String out = String.format("404 NotFound URL%s for method %s", uri, method);
                myHttpResponse.write(out, 404);
                return;
            }
        }
        super.channelRead(ctx, msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
