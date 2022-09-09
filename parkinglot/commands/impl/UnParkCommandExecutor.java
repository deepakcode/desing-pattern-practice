package com.practice.parkinglot.commands.impl;

import com.practice.parkinglot.OutputPrinter;
import com.practice.parkinglot.commands.ICommand;
import com.practice.parkinglot.commands.Command;
import com.practice.parkinglot.service.ParkingLotService;
import com.practice.parkinglot.validator.IntegerValidator;
import java.util.List;

/**
 * Executor to handle command of freeing of slot from a car.
 */
public class UnParkCommandExecutor extends ICommand {
  
  public static String COMMAND_NAME = "unpark";

  public UnParkCommandExecutor(final ParkingLotService parkingLotService,
                               final OutputPrinter outputPrinter) {
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
    final int slotNum = Integer.parseInt(command.getParams().get(0));
    parkingLotService.unPark(slotNum);
    outputPrinter.printWithNewLine("Slot number " + slotNum + " is free");
  }
}
