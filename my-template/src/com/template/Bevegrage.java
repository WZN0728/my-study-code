package com.template;

//榨汁机
//抽象类的好处就是抽象类中的普通方法不需要强制性的去实现，只在使用的时候去掉用就ok
public abstract class Bevegrage {

	public final void create() {
		// 榨汁机，模板模式
		// 1.把水果洗干净
		washFruit();
		// 2.切成块状或片状放入榨汁机中
		getFruitPutInBevegrage();
		// 3.按下榨汁机的开关，开始榨汁
		putDownSwitch();
	}

	public abstract void washFruit();

	public abstract void getFruitPutInBevegrage();

	public void putDownSwitch() {
		System.out.println("按下榨汁机的开关，开始榨汁");
	}

}