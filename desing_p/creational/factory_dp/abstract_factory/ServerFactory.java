package com.practice.desing_p.creational.factory_dp.abstract_factory;

import com.practice.desing_p.creational.factory_dp.Computer;
import com.practice.desing_p.creational.factory_dp.Server;

public class ServerFactory implements ComputerAbstractFactory{

    private String ram;
    private String hdd;
    private String cpu;

    public ServerFactory(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }

    @Override
    public Computer createComputer() {
        return new Server(ram,hdd,cpu);
    }
}
