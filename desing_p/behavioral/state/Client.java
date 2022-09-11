package com.practice.desing_p.behavioral.state;

public class Client {
    public static void main(String[] args) {

        Context_CoffeeMachine context = new Context_CoffeeMachine(); // has default ideal state
        context.handle();

        context.setState(new StateB_PreparingCoffee());
        context.handle();
    }
}
