package com.practice.lld.parkinglot.commands.impl;

import com.practice.lld.parkinglot.OutputPrinter;
import com.practice.lld.parkinglot.commands.CommandExecutor;
import com.practice.lld.parkinglot.exception.NoFreeSlotAvailableException;
import com.practice.lld.parkinglot.model.Car;
import com.practice.lld.parkinglot.commands.Command;
import com.practice.lld.parkinglot.service.ParkingLotService;

/**
 * Executor to handle command of parking a car into the parking lot. This outputs the alloted slot
 * in which the car is parked.
 */
public class ParkCommandExecutorExecutor extends CommandExecutor {

  public static String COMMAND_NAME = "park";

  public ParkCommandExecutorExecutor(
      final ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
    super(parkingLotService, outputPrinter);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean validate(final Command command) {
    return command.getParams().size() == 2;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(final Command command) {
    final Car car = new Car(command.getParams().get(0), command.getParams().get(1));
    try {
      final Integer slot = parkingLotService.park(car);
      outputPrinter.printWithNewLine("Allocated slot number: " + slot);
    } catch (NoFreeSlotAvailableException exception) {
      outputPrinter.parkingLotFull();
    }
  }
}
