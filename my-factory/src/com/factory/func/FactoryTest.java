package com.factory.func;

public class FactoryTest {

	//����ģʽ����ÿ����Ʒ����Ӧ�Լ��Ĺ���
	//��Ҫʲô�ʹ��ĸ��������ȥ��
	//���ǹ���ģʽ���ܰ�ϸ�����أ������Ŀ�Ļ���û�дﵽ
	//�����û���ʹ�õ�ʱ�򲻹����ҵö����Ǵ�������������
	//��Ҫʲô����͸���ʲô
	public static void main(String[] args) {
		Factory factory = new AudiFactory();
		System.out.println(factory.getCar());
		factory = new BenzFactory();
		System.out.println(factory.getCar());
		factory = new BmwFactory();
		System.out.println(factory.getCar());
	}

}