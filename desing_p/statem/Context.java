package com.practice.desing_p.statem;

public class Context {

    State state;

    public Context(){
        state = new StateA(); //Defulat statge
    }

    public State getState() {
        return state;
    }

    public void handle(){
        state.handle();
    }

    public void setState(StateB state) {
        this.state=state;
    }
}
