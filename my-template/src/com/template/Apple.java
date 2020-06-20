package com.template;

public class Apple extends Bevegrage {

	@Override
	public void washFruit() {
		System.out.println("先把苹果洗干净");
	}

	@Override
	public void getFruitPutInBevegrage() {
		System.out.println("在把苹果切成块放入到榨汁机中");
	}

}