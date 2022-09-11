package com.practice.desing_p.behavioral.strategy;

public class CalculateSub implements Strategy {

	@Override
	public void doOperation() {
		System.out.println("Sub : "+(5-2));
	}

}
