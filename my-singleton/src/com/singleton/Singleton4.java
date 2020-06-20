package com.singleton;

public class Singleton4 {

	// ˫�������Ƶ���������ģʽ
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