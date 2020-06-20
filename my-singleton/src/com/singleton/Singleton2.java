package com.singleton;

public class Singleton2 {

	//饿汉模式的单例
	private static Singleton2 instance = new Singleton2();
	
	private Singleton2(){}
	
	public static Singleton2 getInstance(){
		return instance;
	}
	
}