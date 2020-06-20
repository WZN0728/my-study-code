package com.factory.simpleFactory;

import com.factory.Audi;
import com.factory.Benz;
import com.factory.Bmw;
import com.factory.Car;

public class SimpleFactory {

	public Car getCar(String carName) {
		Car car = null;
		if ("Audi".equals(carName)) {
			car = new Audi();
		} else if ("Benz".equals(carName)) {
			car = new Benz();
		} else if ("Bmw".equals(carName)) {
			car = new Bmw();
		} else {
			System.out.println("没有这个产品");
		}
		return car;
	}

}