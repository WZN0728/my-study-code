package com.observer;

public class ObserveTest {

	public static void main(String[] args) {
		Balujun blj = new Balujun();
		blj.addObserver(new Hanjian());
		blj.goFit();
	}

}