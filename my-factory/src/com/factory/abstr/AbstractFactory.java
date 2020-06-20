package com.factory.abstr;

import com.factory.Car;

public abstract class AbstractFactory {

	protected abstract Car getCar();

	public Car getCar(String carName) {
		Car car = null;
		if ("audi".equalsIgnoreCase(carName)) {
			car = new AudiFactory().getCar();
		} else if ("benz".equalsIgnoreCase(carName)) {
			car = new BenzFactory().getCar();
		} else if ("bmw".equalsIgnoreCase(carName)) {
			car = new BmwFactory().getCar();
		} else {
			System.out.println("没有这个工厂");
		}
		return car;
	}

}