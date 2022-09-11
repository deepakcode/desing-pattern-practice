package com.practice.desing_p.creational.factory_dp.factory;

import com.practice.desing_p.creational.factory_dp.Computer;

public class TestFactoryDesignPatterns {

    public static void main(String[] args) {
        testAbstractFactory();
    }

    private static void testAbstractFactory() {
        Computer pcComputer = ComputerFactory.getComputer("PC","2 GB","500 GB","2.4 GHz");
        Computer serverComputer = ComputerFactory.getComputer("Server","16 GB","1 TB","2.9 GHz");
        System.out.println("AbstractFactory PC Config::"+pcComputer);
        System.out.println("AbstractFactory Server Config::"+serverComputer);
    }
}