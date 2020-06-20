/**
 * All rights Reserved, Designed By MyCompany
 *
 * @Title: EmbeddedTomcatServer.java
 * @Package com.test
 * @Copyright: 2018 All rights reserved.
 */
package com.test;

import org.apache.catalina.Context;
import org.apache.catalina.Host;
import org.apache.catalina.Service;
import org.apache.catalina.Wrapper;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

/**
 * @ClassName: EmbeddedTomcatServer
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��4��1�� ����12:59:01
 */
public class EmbeddedTomcatServer {

    public static void main(String[] args) throws Exception {
        // System.getProperty("user.dir")�õ���·��D:\workSpaceByStudy\my-tomcat
        String rootPath = System.getProperty("user.dir");
        String classPath = rootPath + File.separator + "target" + File.separator + "classes";
        System.out.println(classPath);
        Tomcat tomcat = new Tomcat();
        Service service = tomcat.getService();
        tomcat.setPort(9999);
        Host host = tomcat.getHost();
        host.setName("localhost");
        host.setAppBase("webapps");
        String contextPath = "/";
        String webapp = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "webapp";
        Context context = tomcat.addContext(contextPath, webapp);
        if (context instanceof StandardContext) {
            StandardContext standardContext = (StandardContext) context;
            // ����Ĭ�ϵ�web.xml�ļ��� Context
            standardContext.setDefaultWebXml(classPath + File.separator + "conf/web.xml");
            // ���� Classpath �� Context
            // ��� DemoServlet �� Tomcat ����
            Wrapper warpper = tomcat.addServlet(contextPath, "TestServlet", new TestServlet());
            warpper.addMapping("/test");
        }
        // ���� Connector
        /**
         * <Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000"
         * redirectPort="8443" URIEncoding="UTF-8" />
         */
        Connector connector = new Connector();
        connector.setPort(9090);
        connector.setProtocol("HTTP/1.1");
        connector.setURIEncoding("UTF-8");
        service.addConnector(connector);
        tomcat.start();
        tomcat.getServer().await();
    }

}
