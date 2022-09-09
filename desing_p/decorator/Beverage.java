package com.practice.desing_p.decorator;

abstract class Beverage {
    String description = "Beverage";

    String getDescription() {
        return description;
    }

    public abstract double cost();
}