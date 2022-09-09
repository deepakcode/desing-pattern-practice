package com.practice.desing_p.decorator;

class HouseBlend extends Beverage {

    HouseBlend() {
        this.description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 2.5;
    }
}