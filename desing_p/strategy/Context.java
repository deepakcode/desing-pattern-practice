package com.practice.desing_p.strategy;

public class Context {

	Strategy strategy;
	
	public Context(Strategy strategy) {
		this.strategy=strategy;
	}
	
	public void executeStrategy(){
		strategy.doOperation();
	}
	
}
