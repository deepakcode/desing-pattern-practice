package com.practice.desing_p.creational.factory_dp.abstract_factory;

import com.practice.desing_p.creational.factory_dp.Computer;
import com.practice.desing_p.creational.factory_dp.PC;

public class PCFactory implements ComputerAbstractFactory{

    private String ram;
    private String hdd;
    private String cpu;

    public PCFactory(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }

    @Override
    public Computer createComputer() {
        return new PC(ram,hdd,cpu);
    }
}
