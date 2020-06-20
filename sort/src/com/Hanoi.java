/**
 * 
 */
package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <p>
 * ���⣺sort
 * </p>
 * <p>
 * ������Hanoi
 * </p>
 * <p>
 * �����ߣ�wuting
 * </p>
 * <p>
 * �汾��1.0
 * </p>
 * <p>
 * �ļ�����com.Hanoi.java
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
 * ����ʱ�䣺2017��6��9������11:38:36
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
 * �޸�ʱ�䣺2017��6��9������11:38:36
 * </p>
 * <p>
 * �޸����ݣ�
 * </p>
 */
public class Hanoi {

	public static void main(String args[]) throws Exception {
		int n;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("������������");
		n = Integer.parseInt(buf.readLine());
		Hanoi hanoi = new Hanoi();
		hanoi.move(n, 'A', 'B', 'C');
	}

	public void move(int n, char a, char b, char c) {
		if (n == 1)
			System.out.println("�� " + n + " �� " + a + " ���� " + c);
		else {
			move(n - 1, a, c, b);
			System.out.println("�� " + n + " �� " + a + " ���� " + c);
			move(n - 1, b, a, c);
		}
	}
	
	public static void a(int n){
		Hanoi hanoi = new Hanoi();
		hanoi.move(n, 'A', 'B', 'C');
	}

}