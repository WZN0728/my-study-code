package com.cglib;

import com.cglib.dynamic.CGLibDynamicProxyDemo;

public class CGlibProxyTest {

	public static void main(String[] args) {
		//java�е�InvocationHandler�Ķ�̬����ֻ�ܴ���ӿ�
		// ��һ��������Դ����
		// �ڶ����������class�ļ�
		// �����������ص�JVM�У������ر��������

		// ��ʵ����ģʽ�����ֽ�������
		// 1.ͨ�������ȡ�������˵���Ϣ
		// 2.Ȼ������Դ���룬�����class�ļ�
		// 3.�����ص�JVM�������
		// ͨ��������е����õ������Լ��ķ���������������Ϊ���Լ���ɵ�������Ϊû��ʱ���������ʲôԭ���Լ��ɲ��ˣ����Խ������˸ɣ��Ӵ���Ƕ������Ļ���Ҳ���ǽ��Լ��ҷ��ӵķ��������н飩
//		Owner owner = new Owner();
//		owner = (Owner) new Lianjia().getInstance(owner.getClass());
//		owner.findHouse();
		init();
	}
	
	public static void init() {
		Owner owner = new Owner();
		CGLibDynamicProxyDemo cgLibDynamicProxyDemo = new CGLibDynamicProxyDemo();
		Owner owner1 = (Owner)cgLibDynamicProxyDemo.getInstance(owner);
		owner1.findHouse();
	}

}