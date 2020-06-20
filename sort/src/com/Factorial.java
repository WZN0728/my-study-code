/**
 * 
 */
package com;

/**
 * <p>
 * 标题：sort
 * </p>
 * <p>
 * 描述：Factorial
 * </p>
 * <p>
 * 编译者：wuting
 * </p>
 * <p>
 * 版本：1.0
 * </p>
 * <p>
 * 文件名：com.Factorial.java
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
 * 创建时间：2016年12月15日下午2:14:03
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
 * 修改时间：2016年12月15日下午2:14:03
 * </p>
 * <p>
 * 修改内容：
 * </p>
 */
public class Factorial {

	private static long startTime;

	private static long endTime;

	/**
	 * 递归算阶乘m*factorial(m-1)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		startTime = System.nanoTime();
		System.out.println(factorial(7));
		endTime = System.nanoTime();
		System.out.println("递归算阶乘的执行时间为：" + (endTime - startTime) + "ns");
	}

	public static int factorial(int n) {
		if (n == 0 || n == 1 | n == 2) {
			return n;
		} else {
			return n * factorial(n - 1);
		}
	}

}