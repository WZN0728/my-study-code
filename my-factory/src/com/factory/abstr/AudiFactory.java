package com.factory.abstr;

import com.factory.Audi;
import com.factory.Car;

public class AudiFactory extends AbstractFactory {

	@Override
	protected Car getCar() {
		// TODO Auto-generated method stub
		return new Audi();
	}

}