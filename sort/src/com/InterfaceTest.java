/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  InterfaceTest.java
 * @Package com
 * @Copyright: 2018 All rights reserved.
 */
package com;

/**
 * @ClassName: InterfaceTest
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��4��24�� ����11:15:34
 */
public interface InterfaceTest {

	/**
	 * �ӿ��п���������������Ϊ�ӿ��������ǳ������Ƿ������ǹ����ģ�public��,��̬��(static),���յ�/Ĭ�ϵ�(default)
	 * ����Щ���з�����ķ����ǲ���Ҫǿ��ʵ�ֵ�
	 */

	public String value = "asdf";

	public static final String name = "asdf";

	static String getValue() {
		return "Hello World!!��";
	}

	default public void Test() {
		System.out.println("interface test");
	}

}
