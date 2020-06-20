package com.study.demo.netty.tomcat.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;

import java.util.List;
import java.util.Map;

/**
 * @author wuting
 * @date 2019/02/24
 */
public class MyHttpRequest {


    private HttpRequest httpRequest;

    private ChannelHandlerContext channelHandlerContext;

    public MyHttpRequest(ChannelHandlerContext ctx, HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
        this.channelHandlerContext = ctx;
    }

    public String getUri() {
        return httpRequest.getUri();
    }

    public String getMethod() {
        return httpRequest.getMethod().name();
    }

    public Map<String, List<String>> getParameters() {
        QueryStringDecoder queryStringDecoder = new QueryStringDecoder(getUri());
        return queryStringDecoder.parameters();
    }

    public String getParameter(String name) {
        Map<String, List<String>> map = getParameters();
        List<String> list = map.get(name);
        if (list != null) {
            return list.get(0);
        } else {
            return null;
        }
    }

}
