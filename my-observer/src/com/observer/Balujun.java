package com.observer;

import java.util.Observable;

public class Balujun extends Observable {

	public Balujun(){
		super();
	}
	
	private static final int flag = 0;
	
	public void goFit(){
		//����Ҫ���õģ����߹۲��߱��۲���Ҫ�ж�����
		//����
		setChanged();
		System.out.println("��·��ȥ�ƻ��ﱤ��");
		this.notifyObservers(flag);
	}
	
}