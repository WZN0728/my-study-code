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
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2019��2��15�� ����4:59:51
 */
public class CGLibDynamicProxyDemo implements MethodInterceptor {

	private Object target;// ���������

	public Object getInstance(Object obj) {
		this.target = obj;
		Enhancer enhancer = new Enhancer();// ��ǿ��
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
		System.out.println("�����н飬�ҵ�֪����Ҫ��һ��ʲô���ķ���");
		System.out.println("ͨ������Ҫ�ķ�����Ϣ��ʼͨ�����ҵ�ϵͳ���в���");
		Object result = methodProxy.invokeSuper(obj, objs);
		System.out.println("�ҵ������ˣ������������");
		System.out.println("���ʵĻ����Ǿ�ǩ��ͬ");
		return result;
	}

}
