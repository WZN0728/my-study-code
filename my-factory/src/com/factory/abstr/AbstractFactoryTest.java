package com.factory.abstr;

public class AbstractFactoryTest {

	// ���󹤳�����һ�������ﵽ����Ŀ�ĵĹ���
	// ���󹤳��е�Ĭ�Ϲ�����ʵ��������ϸ�ڵĴ���
	// �������û�ֻҪ���ù����Ϳ�����
	// ���ڵ��õ���ʲô�����Ҳ�����
	// ��ֻ�����Ҵ�һ��ʲô���������Ҫ������һ��ʲô��������
	public static void main(String[] args) {
		DefaultFactory df = new DefaultFactory();
		System.out.println(df.getCar());
		System.out.println(df.getCar("Benz"));
		System.out.println(df.getCar("Bmw"));
	}

}