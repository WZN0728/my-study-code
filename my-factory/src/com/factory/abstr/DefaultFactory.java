package com.factory.abstr;

import com.factory.Car;

public class DefaultFactory extends AbstractFactory {

	private AudiFactory defaultFactory = new AudiFactory();

	public Car getCar() {
		return defaultFactory.getCar();
	}

}