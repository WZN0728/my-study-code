package com.template;

//ե֭��
//������ĺô����ǳ������е���ͨ��������Ҫǿ���Ե�ȥʵ�֣�ֻ��ʹ�õ�ʱ��ȥ���þ�ok
public abstract class Bevegrage {

	public final void create() {
		// ե֭����ģ��ģʽ
		// 1.��ˮ��ϴ�ɾ�
		washFruit();
		// 2.�гɿ�״��Ƭ״����ե֭����
		getFruitPutInBevegrage();
		// 3.����ե֭���Ŀ��أ���ʼե֭
		putDownSwitch();
	}

	public abstract void washFruit();

	public abstract void getFruitPutInBevegrage();

	public void putDownSwitch() {
		System.out.println("����ե֭���Ŀ��أ���ʼե֭");
	}

}