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
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2019��2��15�� ����4:59:51
 */
public class JDKDynamicProxyDemo implements InvocationHandler {

	private Object target;// ���������

	//���Զ�̬���������н���
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
		System.out.printf("�������Ĳ���:%s,�������ķ���:%s%n", args, method);
		// �������Ŀ�����ķ���
		Object obj = method.invoke(this.target, args);
		return obj;
	}

}
