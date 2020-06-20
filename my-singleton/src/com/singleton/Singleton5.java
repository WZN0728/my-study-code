package com.singleton;

public class Singleton5 {

	//这个代码没有一行浪费
	//首先是使用一个静态的内部类，因为静态的内部类只有在调用的时候才会去初始化
	//这样的话就解决了饿汉模式中的内存占用问题
	//并且这个静态内部类还是用了final来修饰，保证线程安全
	//JVM的执行过程：1.从上到下2.先静态后动态
	//当然，这里不排除使用反射机制来破坏这个场景的单例
	//因为所有的java代码在反射面前都是裸奔的，因为反射可以拿到任何想要拿到的东西，包括private修饰的
	private static final class LazyHolder {
		private static final Singleton5 INSTANCE = new Singleton5();
	}

	private Singleton5() {
	}

	private static final Singleton5 getInstance() {
		return LazyHolder.INSTANCE;
	}

}