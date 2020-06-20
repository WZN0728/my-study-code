package com.factory.abstr;

import com.factory.Benz;
import com.factory.Car;

public class BenzFactory extends AbstractFactory {

	@Override
	protected Car getCar() {
		// TODO Auto-generated method stub
		return new Benz();
	}

}