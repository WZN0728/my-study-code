package com.test;

public class ArgTest {

	// ���ֲ�����������ǲ������Ϳɱ䣬�ȿ��������飬Ҳ�����ǵ�����ֵ
	public static void test(int... a) {
		// System.out.println(a);
	}

	public static void main(String[] args) {
		int i = 24;
		int j = 24;
		System.out.println("i����j="+i/j);
		System.out.println("i��j="+i%j);
		String s1 = new String("HelloWorld");
		String s2 = new String("HelloWorld1");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println("========================");
		String s3 = "HelloWorld";
		String s4 = "HelloWorld";
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));
		int[] a = { 1, 2, 3 };
		int b = 1;
		test(a);
		test(b);
	}

}