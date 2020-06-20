package com.study.demo.netty.tomcat.http;

/**
 * @author wuting
 * @date 2019/02/24
 */
public abstract class DefaultMyServlet {

    public abstract void doGet(MyHttpRequest myHttpRequest, MyHttpResponse myHttpResponse);

    public abstract void doPost(MyHttpRequest myHttpRequest, MyHttpResponse myHttpResponse) throws Exception;

}
