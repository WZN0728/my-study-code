package com.factory.func;

import com.factory.Audi;
import com.factory.Car;

public class AudiFactory implements Factory{

	@Override
	public Car getCar() {
		// TODO Auto-generated method stub
		return new Audi();
	}
	
}