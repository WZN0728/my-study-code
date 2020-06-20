package com.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Lianjia implements InvocationHandler {

	// 被代理对象作为一个成员变量被保存下来
	private Person target;

	public Object getInstance(Person person) {
		this.target = person;
		Class<?> clazz = target.getClass();
		System.out.println("被代理的对象是：" + clazz.getName());
		return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
	}

	@Override
	public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("我是中介，我得知道你要找一个什么样的房子");
		System.out.println("通过你想要的房子信息开始通过链家的系统进行查找");
		method.invoke(this.target, args);
		System.out.println("找到房子了，你过来看看吧");
		System.out.println("合适的话咱们就签合同");
		return null;
	}

}