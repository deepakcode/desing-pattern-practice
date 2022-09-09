package com.practice.desing_p.decorator;

public class Mocha extends BeverageDecorator{

    Beverage beverage;

    Mocha(Beverage beverage){
        this.beverage=beverage;
    }

    @Override
    public double cost() {
        return beverage.cost()+0.5;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+" Mocha";
    }
}
