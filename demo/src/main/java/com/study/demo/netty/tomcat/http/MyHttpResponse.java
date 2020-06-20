package com.study.demo.netty.tomcat.http;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static io.netty.handler.codec.http.HttpHeaders.Names.*;

/**
 * @author wuting
 * @date 2019/02/24
 */
public class MyHttpResponse {

    private HttpRequest httpRequest;

    private ChannelHandlerContext channelHandlerContext;

    private static Map<Integer, HttpResponseStatus> statusMap = new ConcurrentHashMap<Integer, HttpResponseStatus>();

    static {
        statusMap.put(200, HttpResponseStatus.OK);
        statusMap.put(404, HttpResponseStatus.NOT_FOUND);
    }

    public MyHttpResponse(ChannelHandlerContext ctx, HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
        this.channelHandlerContext = ctx;
    }

    public void write(String out, Integer status) {
        try {
            FullHttpResponse fullHttpResponse = new DefaultFullHttpResponse(
                    HttpVersion.HTTP_1_1,
                    statusMap.get(status),
                    Unpooled.wrappedBuffer(out.getBytes("utf-8")));
            fullHttpResponse.headers().set(CONTENT_TYPE, "text/json");
            fullHttpResponse.headers().set(CONTENT_LENGTH, fullHttpResponse.content().readableBytes());
            fullHttpResponse.headers().set(EXPIRES, 0);
            if (HttpHeaders.isKeepAlive(httpRequest)) {
                fullHttpResponse.headers().set(CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
            }
            channelHandlerContext.write(fullHttpResponse);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            channelHandlerContext.flush();
        }
    }

}
