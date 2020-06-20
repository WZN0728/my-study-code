/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  DynamicProxy.java
 * @Package com.jdk.dynamic
 * @Copyright: 2019 All rights reserved.
 */
package com.cglib.dynamic;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @ClassName: DynamicProxy
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2019年2月15日 下午4:59:51
 */
public class CGLibDynamicProxyDemo implements MethodInterceptor {

	private Object target;// 被代理对象

	public Object getInstance(Object obj) {
		this.target = obj;
		Enhancer enhancer = new Enhancer();// 加强器
		enhancer.setSuperclass(this.target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.cglib.proxy.MethodInterceptor#intercept(java.lang.Object,
	 * java.lang.reflect.Method, java.lang.Object[], net.sf.cglib.proxy.MethodProxy)
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] objs, MethodProxy methodProxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("我是中介，我得知道你要找一个什么样的房子");
		System.out.println("通过你想要的房子信息开始通过链家的系统进行查找");
		Object result = methodProxy.invokeSuper(obj, objs);
		System.out.println("找到房子了，你过来看看吧");
		System.out.println("合适的话咱们就签合同");
		return result;
	}

}
