package com.singleton;

public class Singleton4 {

	// 双重锁机制的懒汉单列模式
	private static volatile Singleton4 instance = null;

	private Singleton4() {
	}

	public static Singleton4 getInstance() {
		if (null == instance) {
			synchronized (instance) {
				if (null == instance) {
					instance = new Singleton4();
				}
			}
		}
		return instance;
	}

}