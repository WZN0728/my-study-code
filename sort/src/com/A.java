/**
 * 
 */
package com;

/**
 * <p>
 * 标题：sort
 * </p>
 * <p>
 * 描述：A
 * </p>
 * <p>
 * 编译者：wuting
 * </p>
 * <p>
 * 版本：1.0
 * </p>
 * <p>
 * 文件名：com.A.java
 * </p>
 * <p>
 * 版权：Copyright (c) 2002-2016 Digitalchina CO.,LTD. All rights reserved.
 * </p>
 * <p>
 * 公司：神州数码系统集成服务有限公司
 * </p>
 * <p>
 * 作者：wuting
 * </p>
 * <p>
 * 创建时间：2017年6月14日上午10:53:34
 * </p>
 * <p>
 * 负责人：wuting
 * </p>
 * <p>
 * 部门：工程院安全可靠研发中心产品研发部
 * </p>
 * <p>
 * 修改者：wuting
 * </p>
 * <p>
 * 修改时间：2017年6月14日上午10:53:34
 * </p>
 * <p>
 * 修改内容：
 * </p>
 */
class A {
	static {
		System.out.println("A的静态块");
	}
	private static String staticStr = getStaticStr();
	private String str = getStr();

	{
		System.out.println("A的实例块");
	}

	public A() {
		System.out.println("A的构造方法");
	}

	private static String getStaticStr() {
		System.out.println("A的静态属性初始化");
		return null;
	}

	private String getStr() {
		System.out.println("A的实例属性初始化");
		return null;
	}

	public static void main(String[] args) {
		new B();
		new B();
	}

}

class B extends A {
	private static String staticStr = getStaticStr();
	static {
		System.out.println("B的静态块");
	}
	{
		System.out.println("B的实例块");
	}

	public B() {
		System.out.println("B的构造方法");
	}

	private String str = getStr();

	private static String getStaticStr() {
		System.out.println("B的静态属性初始化");
		return null;
	}

	private String getStr() {
		System.out.println("B的实例属性初始化");
		return null;
	}
}