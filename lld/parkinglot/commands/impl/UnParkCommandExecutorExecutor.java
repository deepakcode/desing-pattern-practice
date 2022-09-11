package com.practice.lld.parkinglot.commands.impl;

import com.practice.lld.parkinglot.OutputPrinter;
import com.practice.lld.parkinglot.commands.CommandExecutor;
import com.practice.lld.parkinglot.commands.Command;
import com.practice.lld.parkinglot.service.ParkingLotService;
import com.practice.lld.parkinglot.validator.IntegerValidator;
import java.util.List;

/**
 * Executor to handle command of freeing of slot from a car.
 */
public class UnParkCommandExecutorExecutor extends CommandExecutor {
  
  public static String COMMAND_NAME = "unpark";

  public UnParkCommandExecutorExecutor(final ParkingLotService parkingLotService,
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
