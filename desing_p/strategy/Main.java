package com.practice.desing_p.strategy;

public class Main {
	public static void main(String[] args) {
		Context context = new Context(new CalculateSub());
		//Context context = new Context(new CalculateSum());
		context.executeStrategy();
	}
}
