package com.factory.func;

import com.factory.Bmw;
import com.factory.Car;

public class BmwFactory implements Factory{

	@Override
	public Car getCar() {
		// TODO Auto-generated method stub
		return new Bmw();
	}
	
}