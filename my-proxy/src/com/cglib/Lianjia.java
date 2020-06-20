package com.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class Lianjia implements MethodInterceptor {

	public Object getInstance(Class<?> clazz) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("�����н飬�ҵ�֪����Ҫ��һ��ʲô���ķ���");
		System.out.println("ͨ������Ҫ�ķ�����Ϣ��ʼͨ�����ҵ�ϵͳ���в���");
		proxy.invokeSuper(obj, args);
		System.out.println("�ҵ������ˣ������������");
		System.out.println("���ʵĻ����Ǿ�ǩ��ͬ");
		return null;
	}

}