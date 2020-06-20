package com.template;

public class Orange extends Bevegrage {

	@Override
	public void washFruit() {
		System.out.println("先把橘子剥皮");
	}

	@Override
	public void getFruitPutInBevegrage() {
		System.out.println("再把橘子掰开放入到榨汁机中");
	}

}