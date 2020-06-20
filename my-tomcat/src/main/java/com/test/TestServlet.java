/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  TestServlet.java
 * @Package com.test
 * @Copyright: 2018 All rights reserved.
 */
package com.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: TestServlet
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年3月29日 下午11:09:28
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 乱码的解决方式，<Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000"
		 * redirectPort="8443" URIEncoding="UTF-8"/>
		 */
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String message = req.getParameter("message");
		resp.getWriter().println(message);
		resp.getWriter().println("<br/>");
		String contextPath = req.getServletContext().getContextPath();
		resp.getWriter().println("context path : " + contextPath);
	}

}
