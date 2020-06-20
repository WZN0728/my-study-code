/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  MyDispatcherServlet.java
 * @Package com.framework
 * @Copyright: 2018 All rights reserved.
 */
package com.framework.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.framework.context.MyApplicationContext;

/**
 * @ClassName: MyDispatcherServlet
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��4��15�� ����9:36:49
 */
public class MyDispatcherServlet extends HttpServlet {

	/**
	 * @Fields serialVersionUID : TODO(��һ�仰�������������ʾʲô)
	 */
	private static final long serialVersionUID = 1L;

	private static final String LOCATION = "contextConfigLocation";
	
	private Map<String,Handler> handlerMapping = new ConcurrentHashMap<String,Handler>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			doDispatch(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
			resp.getWriter().write("500 Exception, Message:" + Arrays.toString(e.getStackTrace()));
		}
	}

	public void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//��ȡһ��handlerMapping
		Handler handler = getHandler();
		if (handler == null) {
			return;
		}
		//��handlerMapping�л�ȡhandler
		HandlerAdapter ha = getHandlerAdapter(handler);
		ha.handle(req, resp, handler);
	}
	
	/**
	 * HandlerMapping�Ķ���
	 * 
	 * @ClassName: Handler
	 * @Description:TODO(������һ�仰��������������)
	 * @author: ��ͣ
	 * @date: 2018��4��28�� ����8:03:51
	 */
	private class Handler {
		public void getHandler() {

		}
	}

	/**
	 * handler��������
	 * 
	 * @ClassName: HandlerAdapter
	 * @Description:TODO(������һ�仰��������������)
	 * @author: ��ͣ
	 * @date: 2018��4��28�� ����8:04:04
	 */
	private class HandlerAdapter {

		/**
		 * @Title: handle @Description: TODO(������һ�仰�����������������) @param: @param
		 * req @param: @param resp @param: @param handler @return: void @throws
		 */
		public void handle(HttpServletRequest req, HttpServletResponse resp, Handler handler) {
			// TODO Auto-generated method stub

		}
	}

	private Handler getHandler() {
		return null;
	}
	
	public HandlerAdapter getHandlerAdapter(Handler handler) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// ����Ҫ����һ���Լ���springIOC����
		MyApplicationContext applicationContext = new MyApplicationContext(config.getInitParameter(LOCATION));
		// ���￪ʼ����spring MVC�ľŴ���
		// �������
		initMultipartResolver(applicationContext);
		// �����ԡ����ʻ�
		initLocaleResolver(applicationContext);
		// ����View���
		initThemeResolver(applicationContext);
		//********************��Ҫ*****************************
		// ����url��Method�Ĺ�����ϵ
		initHandlerMappings(applicationContext);
		// ��������ƥ��Ĺ��̣�
		initHandlerAdapters(applicationContext);
		//********************��Ҫ*****************************
		// �쳣����
		initHandlerExceptionResolvers(applicationContext);
		// ��ͼת����������ͼ����ƥ�䵽һ������ģ�壩
		initRequestToViewNameTranslator(applicationContext);
		// ����ģ���е����ݣ��õ������������������ݣ�����HTML���룩
		initViewResolvers(applicationContext);
		//
		initFlashMapManager(applicationContext);
		System.out.println("*************************************************");
		System.out.println("MyDispatcherServlet is init");
		Map<String,Object> ioc = applicationContext.getInstanceAll();
		System.out.println(ioc.size());
		System.out.println(ioc.get("testAction"));
	}

	// �������
	private void initMultipartResolver(MyApplicationContext applicationContext) {
	}

	// �����ԡ����ʻ�
	private void initLocaleResolver(MyApplicationContext applicationContext) {
	}

	// ����View���
	private void initThemeResolver(MyApplicationContext applicationContext) {
	}

	// ����url��Method�Ĺ�����ϵ
	private void initHandlerMappings(MyApplicationContext applicationContext) {
	}

	// ��������ƥ��Ĺ��̣�
	private void initHandlerAdapters(MyApplicationContext applicationContext) {
	}

	// �쳣����
	private void initHandlerExceptionResolvers(MyApplicationContext applicationContext) {
	}

	// ��ͼת����������ͼ����ƥ�䵽һ������ģ�壩
	private void initRequestToViewNameTranslator(MyApplicationContext applicationContext) {
	}

	// ����ģ���е����ݣ��õ������������������ݣ�����HTML���룩
	private void initViewResolvers(MyApplicationContext applicationContext) {
	}

	//
	private void initFlashMapManager(MyApplicationContext applicationContext) {
	}

}
