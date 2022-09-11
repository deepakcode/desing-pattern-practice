package com.practice.desing_p.behavioral.observable;

public class Main {

    public static void main(String[] args) {
        WheatherStation station = new WheatherStation();
        DataObserverOne observerOne = new DataObserverOne(station);
        observerOne.register();

        DataObserverTwo observerTwo = new DataObserverTwo(station);
        observerTwo.register();

        station.setData(23);
        station.setData(28);
    }
}
