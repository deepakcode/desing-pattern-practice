package com.practice.parkinglot.commands.impl;

import com.practice.parkinglot.OutputPrinter;
import com.practice.parkinglot.commands.ICommand;
import com.practice.parkinglot.commands.Command;
import com.practice.parkinglot.model.ParkingLot;
import com.practice.parkinglot.model.parking.strategy.NaturalOrderingParkingStrategy;
import com.practice.parkinglot.service.ParkingLotService;
import com.practice.parkinglot.validator.IntegerValidator;
import java.util.List;

/**
 * Executor to handle command of creating the initial parking lot.
 */
public class CreateParkingLotCommandExecutor extends ICommand {
  public static String COMMAND_NAME = "create_parking_lot";

  public CreateParkingLotCommandExecutor(
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
