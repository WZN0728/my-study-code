package com.observer;

import java.util.Observable;
import java.util.Observer;

public class Hanjian implements Observer {
	
	public Hanjian(){}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("����̫��"+arg);
		System.out.println("��·��Ҫȥ�ƻ��ﱤ��");
	}

}