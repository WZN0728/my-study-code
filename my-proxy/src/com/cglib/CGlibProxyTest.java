package com.cglib;

import com.cglib.dynamic.CGLibDynamicProxyDemo;

public class CGlibProxyTest {

	public static void main(String[] args) {
		//java中的InvocationHandler的动态代理只能代理接口
		// 第一步、生成源代码
		// 第二步、编译成class文件
		// 第三步、加载到JVM中，并返回被代理对象

		// 其实代理模式就是字节码重组
		// 1.通过反射获取被代理人的信息
		// 2.然后生成源代码，编译成class文件
		// 3.最后加载到JVM虚拟机中
		// 通过虚拟机中的引用调用他自己的方法（这里可以理解为我自己想干的事情因为没有时间或者其他什么原因自己干不了，所以交给别人干，从代码角度来看的话，也就是将自己找房子的方法交给中介）
//		Owner owner = new Owner();
//		owner = (Owner) new Lianjia().getInstance(owner.getClass());
//		owner.findHouse();
		init();
	}
	
	public static void init() {
		Owner owner = new Owner();
		CGLibDynamicProxyDemo cgLibDynamicProxyDemo = new CGLibDynamicProxyDemo();
		Owner owner1 = (Owner)cgLibDynamicProxyDemo.getInstance(owner);
		owner1.findHouse();
	}

}