package com.factory.simpleFactory;

public class SimpleFactoryTest {

	//�򵥹�������һ���������ʲô����������ʵ�������Ĺ���Ҳ������
	//���һ������ʲô���������Ǿ���һ������ʲô�������˵Ĺ���
	//˭����һ�����������Ĺ��������������������أ�˭�����أ�
	//�򵥹�������û�н����ϵ�����
	public static void main(String[] args) {
		SimpleFactory simpleFactory = new SimpleFactory();
		System.out.println(simpleFactory.getCar("Audi"));
		System.out.println(simpleFactory.getCar("Benz"));
		System.out.println(simpleFactory.getCar("Bmw"));
	}
	
}