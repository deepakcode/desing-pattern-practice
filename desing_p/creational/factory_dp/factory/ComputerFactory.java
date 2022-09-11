package com.practice.desing_p.creational.factory_dp.factory;

import com.practice.desing_p.creational.factory_dp.Computer;
import com.practice.desing_p.creational.factory_dp.PC;
import com.practice.desing_p.creational.factory_dp.Server;

public class ComputerFactory {

    public static Computer getComputer(String type, String ram, String hdd, String cpu) {
        if ("PC".equalsIgnoreCase(type)) return new PC(ram, hdd, cpu);
        else if ("Server".equalsIgnoreCase(type)) return new Server(ram, hdd, cpu);
        return null;
    }
}