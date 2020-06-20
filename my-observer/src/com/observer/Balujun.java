package com.observer;

import java.util.Observable;

public class Balujun extends Observable {

	public Balujun(){
		super();
	}
	
	private static final int flag = 0;
	
	public void goFit(){
		//必须要调用的，告诉观察者被观察者要有动作了
		//核心
		setChanged();
		System.out.println("八路军去破坏碉堡了");
		this.notifyObservers(flag);
	}
	
}