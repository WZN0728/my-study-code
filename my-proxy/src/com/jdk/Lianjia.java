package com.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Lianjia implements InvocationHandler {

	// �����������Ϊһ����Ա��������������
	private Person target;

	public Object getInstance(Person person) {
		this.target = person;
		Class<?> clazz = target.getClass();
		System.out.println("������Ķ����ǣ�" + clazz.getName());
		return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
	}

	@Override
	public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("�����н飬�ҵ�֪����Ҫ��һ��ʲô���ķ���");
		System.out.println("ͨ������Ҫ�ķ�����Ϣ��ʼͨ�����ҵ�ϵͳ���в���");
		method.invoke(this.target, args);
		System.out.println("�ҵ������ˣ������������");
		System.out.println("���ʵĻ����Ǿ�ǩ��ͬ");
		return null;
	}

}