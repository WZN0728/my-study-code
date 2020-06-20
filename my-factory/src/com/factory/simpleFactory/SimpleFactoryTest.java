package com.factory.simpleFactory;

public class SimpleFactoryTest {

	//简单工厂就是一个工厂里边什么都能做，现实中这样的工厂也不存在
	//如果一个工厂什么都能做，那就是一个根本什么都做不了的工厂
	//谁能买一个从做汽车的工厂里边生产出来的面包呢（谁敢买呢）
	//简单工厂最终没有解决耦合的问题
	public static void main(String[] args) {
		SimpleFactory simpleFactory = new SimpleFactory();
		System.out.println(simpleFactory.getCar("Audi"));
		System.out.println(simpleFactory.getCar("Benz"));
		System.out.println(simpleFactory.getCar("Bmw"));
	}
	
}