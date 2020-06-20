package com.factory.abstr;

public class AbstractFactoryTest {

	// 抽象工厂才是一个真正达到解耦目的的工厂
	// 抽象工厂中的默认工厂其实就是隐藏细节的存在
	// 在这里用户只要调用工厂就可以了
	// 至于调用的是什么工厂我不关心
	// 我只关心我传一个什么东西，你就要给我造一个什么东西出来
	public static void main(String[] args) {
		DefaultFactory df = new DefaultFactory();
		System.out.println(df.getCar());
		System.out.println(df.getCar("Benz"));
		System.out.println(df.getCar("Bmw"));
	}

}