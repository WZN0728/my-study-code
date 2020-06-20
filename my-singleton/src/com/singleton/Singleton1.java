package com.singleton;

public class Singleton1 {

	//懒汉模式的单例
	private static Singleton1 instance = null;
	
	private Singleton1(){}
	
	public static Singleton1 getInstance(){
		if(null == instance){
			instance = new Singleton1();
		}
		return instance;
	}
	
}