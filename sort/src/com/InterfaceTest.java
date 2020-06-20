/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  InterfaceTest.java
 * @Package com
 * @Copyright: 2018 All rights reserved.
 */
package com;

/**
 * @ClassName: InterfaceTest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月24日 下午11:15:34
 */
public interface InterfaceTest {

	/**
	 * 接口中可以声明常量，因为接口中无论是常量还是方法都是公共的（public）,静态的(static),最终的/默认的(default)
	 * 而这些带有方法体的方法是不需要强制实现的
	 */

	public String value = "asdf";

	public static final String name = "asdf";

	static String getValue() {
		return "Hello World!!！";
	}

	default public void Test() {
		System.out.println("interface test");
	}

}
