package com.practice.desing_p.creational.factory_dp.abstract_factory;

import com.practice.desing_p.creational.factory_dp.Computer;

public class ComputerFactory {

    public static Computer getComputer(ComputerAbstractFactory factory) {
        return factory.createComputer();
    }
}
