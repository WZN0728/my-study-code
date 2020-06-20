package com.prototype.greatestsage;

import java.io.Serializable;

public class GoldRingedStaff implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -194376663808186159L;

	private static int height = 100;

	private static int diameter = 5;

	public void grow() {
		this.height = height * 2;
		this.diameter = diameter * 2;
	}

	public void shrink() {
		this.height = height / 2;
		this.diameter = diameter / 2;
	}

}