package com.factory.func;

public class FactoryTest {

	//工厂模式就是每个产品都对应自己的工厂
	//想要什么就从哪个工厂里边去拿
	//但是工厂模式不能把细节隐藏，解耦的目的还是没有达到
	//而且用户在使用的时候不管心我得东西是从哪生产出来的
	//我要什么，你就给我什么
	public static void main(String[] args) {
		Factory factory = new AudiFactory();
		System.out.println(factory.getCar());
		factory = new BenzFactory();
		System.out.println(factory.getCar());
		factory = new BmwFactory();
		System.out.println(factory.getCar());
	}

}