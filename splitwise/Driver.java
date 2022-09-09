package com.practice.splitwise;

import com.practice.splitwise.models.User;
import com.practice.splitwise.models.expense.ExpenseType;
import com.practice.splitwise.models.split.EqualSplit;
import com.practice.splitwise.models.split.ExactSplit;
import com.practice.splitwise.models.split.PercentSplit;
import com.practice.splitwise.models.split.Split;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
    	System.out.println("-Started---");
        ExpenseManager expenseManager = new ExpenseManager();

        expenseManager.addUser(new User("U1", "User1", "gaurav@workat.tech", "9876543210"));
        expenseManager.addUser(new User("U2", "User2", "sagar@workat.tech", "9876543210"));
        expenseManager.addUser(new User("U3", "User3", "hi@workat.tech", "9876543210"));
        expenseManager.addUser(new User("U" +
                "4", "User4", "mock-interviews@workat.tech", "9876543210"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            String[] commands = command.split(" ");
            String commandType = commands[0];

            switch (commandType) {
                case "SHOW":
                    if (commands.length == 1) {
                        expenseManager.showBalances();
                    } else {
                        expenseManager.showBalance(commands[1]);
                    }
                    break;
                case "EXPENSE":
                    String paidBy = commands[1];
                    Double amount = Double.parseDouble(commands[2]);
                    int noOfUsers = Integer.parseInt(commands[3]);
                    String expenseType = commands[4 + noOfUsers];
                    List<Split> splits = new ArrayList<>();
                    switch (expenseType) {
                        case "EQUAL":
                            for (int i = 0; i < noOfUsers; i++) {
                                splits.add(new EqualSplit(expenseManager.userMap.get(commands[4 + i])));
                            }
                            expenseManager.addExpense(ExpenseType.EQUAL, amount, paidBy, splits, null);
                            break;
                        case "EXACT":
                            for (int i = 0; i < noOfUsers; i++) {
                                splits.add(new ExactSplit(expenseManager.userMap.get(commands[4 + i]), Double.parseDouble(commands[5 + noOfUsers + i])));
                            }
                            expenseManager.addExpense(ExpenseType.EXACT, amount, paidBy, splits, null);
                            break;
                        case "PERCENT":
                            for (int i = 0; i < noOfUsers; i++) {
                                splits.add(new PercentSplit(expenseManager.userMap.get(commands[4 + i]), Double.parseDouble(commands[5 + noOfUsers + i])));
                            }
                            expenseManager.addExpense(ExpenseType.PERCENT, amount, paidBy, splits, null);
                            break;
                    }
                    break;
            }
        }
    }
}