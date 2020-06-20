/**
 * 
 */
package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <p>
 * 标题：sort
 * </p>
 * <p>
 * 描述：Hanoi
 * </p>
 * <p>
 * 编译者：wuting
 * </p>
 * <p>
 * 版本：1.0
 * </p>
 * <p>
 * 文件名：com.Hanoi.java
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
 * 创建时间：2017年6月9日上午11:38:36
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
 * 修改时间：2017年6月9日上午11:38:36
 * </p>
 * <p>
 * 修改内容：
 * </p>
 */
public class Hanoi {

	public static void main(String args[]) throws Exception {
		int n;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入盘数：");
		n = Integer.parseInt(buf.readLine());
		Hanoi hanoi = new Hanoi();
		hanoi.move(n, 'A', 'B', 'C');
	}

	public void move(int n, char a, char b, char c) {
		if (n == 1)
			System.out.println("盘 " + n + " 由 " + a + " 移至 " + c);
		else {
			move(n - 1, a, c, b);
			System.out.println("盘 " + n + " 由 " + a + " 移至 " + c);
			move(n - 1, b, a, c);
		}
	}
	
	public static void a(int n){
		Hanoi hanoi = new Hanoi();
		hanoi.move(n, 'A', 'B', 'C');
	}

}