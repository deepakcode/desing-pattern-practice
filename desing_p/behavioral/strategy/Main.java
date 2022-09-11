package com.practice.desing_p.behavioral.strategy;

public class Main {
	public static void main(String[] args) {
		Context context = new Context(new CalculateSub());
		//Context_CoffeeMachine context = new Context_CoffeeMachine(new CalculateSum());
		context.executeStrategy();
	}
}
