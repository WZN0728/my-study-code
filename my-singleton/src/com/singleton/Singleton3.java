package com.singleton;

public class Singleton3 {

	//一个线程安全的懒汉单例
	private static volatile Singleton3 instance = null;
	
	private Singleton3(){}
	
	public synchronized static Singleton3 getInstace(){
		if(null == instance){
			instance = new Singleton3();
		}
		return instance;
	}
	
}