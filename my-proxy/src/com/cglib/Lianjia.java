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
		System.out.println("我是中介，我得知道你要找一个什么样的房子");
		System.out.println("通过你想要的房子信息开始通过链家的系统进行查找");
		proxy.invokeSuper(obj, args);
		System.out.println("找到房子了，你过来看看吧");
		System.out.println("合适的话咱们就签合同");
		return null;
	}

}