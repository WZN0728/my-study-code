package com.observer;

import java.util.Observable;
import java.util.Observer;

public class Hanjian implements Observer {
	
	public Hanjian(){}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("报告太君"+arg);
		System.out.println("八路军要去破坏碉堡了");
	}

}