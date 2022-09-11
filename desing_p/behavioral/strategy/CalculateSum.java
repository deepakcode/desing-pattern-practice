package com.practice.desing_p.behavioral.strategy;

public class CalculateSum implements Strategy {

	@Override
	public void doOperation() {
		System.out.println("Sum : "+(5+2));
	}

}
