package com.factory.abstr;

import com.factory.Bmw;
import com.factory.Car;

public class BmwFactory extends AbstractFactory {

	@Override
	protected Car getCar() {
		// TODO Auto-generated method stub
		return new Bmw();
	}

}