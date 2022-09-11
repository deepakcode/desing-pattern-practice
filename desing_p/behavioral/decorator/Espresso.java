package com.practice.desing_p.behavioral.decorator;

class Espresso extends Beverage {

    Espresso() {
        this.description = "Espresso";
    }

    @Override
    public double cost() {
        return 2.6;
    }
}