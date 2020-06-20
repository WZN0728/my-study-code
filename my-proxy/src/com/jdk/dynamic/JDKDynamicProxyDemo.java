/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  DynamicProxy.java
 * @Package com.jdk.dynamic
 * @Copyright: 2019 All rights reserved.
 */
package com.jdk.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName: DynamicProxy
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2019年2月15日 下午4:59:51
 */
public class JDKDynamicProxyDemo implements InvocationHandler {

	private Object target;// 被代理对象

	//可以动态代理所有中介类
	public Object bind(Object obj) {
		this.target = obj;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object,
	 * java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.printf("代理对象的参数:%s,代理对象的方法:%s%n", args, method);
		// 反射调用目标对象的方法
		Object obj = method.invoke(this.target, args);
		return obj;
	}

}
