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
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月15日 下午9:36:49
 */
public class MyDispatcherServlet extends HttpServlet {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
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
		//获取一个handlerMapping
		Handler handler = getHandler();
		if (handler == null) {
			return;
		}
		//从handlerMapping中获取handler
		HandlerAdapter ha = getHandlerAdapter(handler);
		ha.handle(req, resp, handler);
	}
	
	/**
	 * HandlerMapping的定义
	 * 
	 * @ClassName: Handler
	 * @Description:TODO(这里用一句话描述这个类的作用)
	 * @author: 吴停
	 * @date: 2018年4月28日 下午8:03:51
	 */
	private class Handler {
		public void getHandler() {

		}
	}

	/**
	 * handler的适配器
	 * 
	 * @ClassName: HandlerAdapter
	 * @Description:TODO(这里用一句话描述这个类的作用)
	 * @author: 吴停
	 * @date: 2018年4月28日 下午8:04:04
	 */
	private class HandlerAdapter {

		/**
		 * @Title: handle @Description: TODO(这里用一句话描述这个方法的作用) @param: @param
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
		// 首先要启动一个自己的springIOC容器
		MyApplicationContext applicationContext = new MyApplicationContext(config.getInitParameter(LOCATION));
		// 这里开始就是spring MVC的九大步骤
		// 请求解析
		initMultipartResolver(applicationContext);
		// 多语言、国际化
		initLocaleResolver(applicationContext);
		// 主题View层的
		initThemeResolver(applicationContext);
		//********************重要*****************************
		// 解析url和Method的关联关系
		initHandlerMappings(applicationContext);
		// 适配器（匹配的过程）
		initHandlerAdapters(applicationContext);
		//********************重要*****************************
		// 异常解析
		initHandlerExceptionResolvers(applicationContext);
		// 视图转发（根据视图名字匹配到一个具体模板）
		initRequestToViewNameTranslator(applicationContext);
		// 解析模板中的内容（拿到服务器传过来的数据，生成HTML代码）
		initViewResolvers(applicationContext);
		//
		initFlashMapManager(applicationContext);
		System.out.println("*************************************************");
		System.out.println("MyDispatcherServlet is init");
		Map<String,Object> ioc = applicationContext.getInstanceAll();
		System.out.println(ioc.size());
		System.out.println(ioc.get("testAction"));
	}

	// 请求解析
	private void initMultipartResolver(MyApplicationContext applicationContext) {
	}

	// 多语言、国际化
	private void initLocaleResolver(MyApplicationContext applicationContext) {
	}

	// 主题View层的
	private void initThemeResolver(MyApplicationContext applicationContext) {
	}

	// 解析url和Method的关联关系
	private void initHandlerMappings(MyApplicationContext applicationContext) {
	}

	// 适配器（匹配的过程）
	private void initHandlerAdapters(MyApplicationContext applicationContext) {
	}

	// 异常解析
	private void initHandlerExceptionResolvers(MyApplicationContext applicationContext) {
	}

	// 视图转发（根据视图名字匹配到一个具体模板）
	private void initRequestToViewNameTranslator(MyApplicationContext applicationContext) {
	}

	// 解析模板中的内容（拿到服务器传过来的数据，生成HTML代码）
	private void initViewResolvers(MyApplicationContext applicationContext) {
	}

	//
	private void initFlashMapManager(MyApplicationContext applicationContext) {
	}

}
