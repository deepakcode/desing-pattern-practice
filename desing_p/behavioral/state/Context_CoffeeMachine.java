package com.practice.desing_p.behavioral.state;

public class Context_CoffeeMachine {

    State state;

    public Context_CoffeeMachine(){
        state = new StateA_IdealState(); //Defulat statge
    }

    public State getState() {
        return state;
    }

    public void handle(){
        state.handle();
    }

    public void setState(StateB_PreparingCoffee state) {
        this.state=state;
    }
}
