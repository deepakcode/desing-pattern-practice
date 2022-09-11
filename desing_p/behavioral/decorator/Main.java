package com.practice.desing_p.behavioral.decorator;

public class Main {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription());
        System.out.println(beverage.cost());


        Beverage mochaExpresso = new Mocha(new Espresso());
        System.out.println(mochaExpresso.getDescription());
        System.out.println(mochaExpresso.cost());

        Beverage mochaMochaHouseBlend = new Mocha(new Mocha(new HouseBlend()));
        System.out.println(mochaMochaHouseBlend.getDescription());
        System.out.println(mochaMochaHouseBlend.cost());

    }
}
