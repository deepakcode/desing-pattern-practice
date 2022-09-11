package com.practice.lld.parkinglot.commands.impl;

import com.practice.lld.parkinglot.OutputPrinter;
import com.practice.lld.parkinglot.commands.CommandExecutor;
import com.practice.lld.parkinglot.commands.Command;
import com.practice.lld.parkinglot.model.ParkingLot;
import com.practice.lld.parkinglot.model.parking.strategy.NaturalOrderingParkingStrategy;
import com.practice.lld.parkinglot.service.ParkingLotService;
import com.practice.lld.parkinglot.validator.IntegerValidator;
import java.util.List;

/**
 * Executor to handle command of creating the initial parking lot.
 */
public class CreateParkingLotCommandExecutorExecutor extends CommandExecutor {
  public static String COMMAND_NAME = "create_parking_lot";

  public CreateParkingLotCommandExecutorExecutor(
      final ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
    super(parkingLotService, outputPrinter);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean validate(final Command command) {
    final List<String> params = command.getParams();
    if (params.size() != 1) {
      return false;
    }
    return IntegerValidator.isInteger(params.get(0));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(final Command command) {
    final int parkingLotCapacity = Integer.parseInt(command.getParams().get(0));
    final ParkingLot parkingLot = new ParkingLot(parkingLotCapacity);
    parkingLotService.createParkingLot(parkingLot, new NaturalOrderingParkingStrategy());
    outputPrinter.printWithNewLine(
        "Created a parking lot with " + parkingLot.getCapacity() + " slots");
  }
}
