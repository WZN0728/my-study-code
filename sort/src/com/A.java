/**
 * 
 */
package com;

/**
 * <p>
 * ���⣺sort
 * </p>
 * <p>
 * ������A
 * </p>
 * <p>
 * �����ߣ�wuting
 * </p>
 * <p>
 * �汾��1.0
 * </p>
 * <p>
 * �ļ�����com.A.java
 * </p>
 * <p>
 * ��Ȩ��Copyright (c) 2002-2016 Digitalchina CO.,LTD. All rights reserved.
 * </p>
 * <p>
 * ��˾����������ϵͳ���ɷ������޹�˾
 * </p>
 * <p>
 * ���ߣ�wuting
 * </p>
 * <p>
 * ����ʱ�䣺2017��6��14������10:53:34
 * </p>
 * <p>
 * �����ˣ�wuting
 * </p>
 * <p>
 * ���ţ�����Ժ��ȫ�ɿ��з����Ĳ�Ʒ�з���
 * </p>
 * <p>
 * �޸��ߣ�wuting
 * </p>
 * <p>
 * �޸�ʱ�䣺2017��6��14������10:53:34
 * </p>
 * <p>
 * �޸����ݣ�
 * </p>
 */
class A {
	static {
		System.out.println("A�ľ�̬��");
	}
	private static String staticStr = getStaticStr();
	private String str = getStr();

	{
		System.out.println("A��ʵ����");
	}

	public A() {
		System.out.println("A�Ĺ��췽��");
	}

	private static String getStaticStr() {
		System.out.println("A�ľ�̬���Գ�ʼ��");
		return null;
	}

	private String getStr() {
		System.out.println("A��ʵ�����Գ�ʼ��");
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
		System.out.println("B�ľ�̬��");
	}
	{
		System.out.println("B��ʵ����");
	}

	public B() {
		System.out.println("B�Ĺ��췽��");
	}

	private String str = getStr();

	private static String getStaticStr() {
		System.out.println("B�ľ�̬���Գ�ʼ��");
		return null;
	}

	private String getStr() {
		System.out.println("B��ʵ�����Գ�ʼ��");
		return null;
	}
}