package com.study.demo.netty.tomcat.servlet;

import com.study.demo.netty.tomcat.http.MyHttpRequest;
import com.study.demo.netty.tomcat.http.MyHttpResponse;
import com.study.demo.netty.tomcat.http.MyServlet;

/**
 * @author wuting
 * @date 2019/02/24
 */
public class FirstServlet extends MyServlet {

    @Override
    public void doGet(MyHttpRequest myHttpRequest, MyHttpResponse myHttpResponse) {
        doPost(myHttpRequest, myHttpResponse);
    }

    @Override
    public void doPost(MyHttpRequest myHttpRequest, MyHttpResponse myHttpResponse) {
        String name = "name";
        String value = myHttpRequest.getParameter(name);
        myHttpResponse.write(name + ":" + value, 200);
    }

}
