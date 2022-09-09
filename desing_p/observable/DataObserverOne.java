package com.practice.desing_p.observable;

public class DataObserverOne implements Observer{

    private Subject observable;

    public DataObserverOne(Subject observable) {
        this.observable = observable;
    }

    int data;

    @Override
    public void update(int data) {
        this.data=data;
        display();
    }

    @Override
    public void display() {
        System.out.println("Data from One : "+data);
    }

    public void register(){
        observable.registerObserver(this);
    }

}
