package com.factory.func;

import com.factory.Benz;
import com.factory.Car;

public class BenzFactory implements Factory{

	@Override
	public Car getCar() {
		// TODO Auto-generated method stub
		return new Benz();
	}
	
}