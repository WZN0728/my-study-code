package com.singleton;

public class Singleton5 {

	//�������û��һ���˷�
	//������ʹ��һ����̬���ڲ��࣬��Ϊ��̬���ڲ���ֻ���ڵ��õ�ʱ��Ż�ȥ��ʼ��
	//�����Ļ��ͽ���˶���ģʽ�е��ڴ�ռ������
	//���������̬�ڲ��໹������final�����Σ���֤�̰߳�ȫ
	//JVM��ִ�й��̣�1.���ϵ���2.�Ⱦ�̬��̬
	//��Ȼ�����ﲻ�ų�ʹ�÷���������ƻ���������ĵ���
	//��Ϊ���е�java�����ڷ�����ǰ�����㱼�ģ���Ϊ��������õ��κ���Ҫ�õ��Ķ���������private���ε�
	private static final class LazyHolder {
		private static final Singleton5 INSTANCE = new Singleton5();
	}

	private Singleton5() {
	}

	private static final Singleton5 getInstance() {
		return LazyHolder.INSTANCE;
	}

}