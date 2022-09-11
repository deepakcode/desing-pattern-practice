package com.practice.lld.splitwise;

import com.practice.lld.splitwise.models.User;
import com.practice.lld.splitwise.models.expense.Expense;
import com.practice.lld.splitwise.models.expense.ExpenseMetadata;
import com.practice.lld.splitwise.models.expense.ExpenseType;
import com.practice.lld.splitwise.models.split.Split;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
	
    List<Expense> expenses;
    
    //userId, User
    Map<String, User> userMap;
    
    //userId, 
    Map<String, Map<String, Double> > balanceSheet;

    public ExpenseManager() {
        expenses = new ArrayList<Expense>();
        userMap = new HashMap<String, User>();
        balanceSheet = new HashMap<String, Map<String, Double>>();
    }

    public void addUser(User user) {
        userMap.put(user.getId(), user);
        balanceSheet.put(user.getId(), new HashMap<String, Double>());
    }

    public void addExpense(ExpenseType expenseType, double amount, String paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
        
    	Expense expense = ExpenseService.createExpense(expenseType, amount, userMap.get(paidBy), splits, expenseMetadata);

        //ADDING FOR AUDIT PURPOSE
    	expenses.add(expense);

        //DO RECONSILATION IN BALANCE SHEET BASED UPON SLIT
        for (Split forEachsplit : expense.getSplits()) {
        	
            String userId = forEachsplit.getUser().getId();
            
            Map<String, Double> paidBybalances = balanceSheet.get(paidBy);
            
            
            if (!paidBybalances.containsKey(userId)) {
                paidBybalances.put(userId, 0.0); //setting default value
            }
            
            paidBybalances.put(userId, paidBybalances.get(userId) + forEachsplit.getAmount()); // updated amount that need to collect.

            paidBybalances = balanceSheet.get(userId);
            if (!paidBybalances.containsKey(paidBy)) {
                paidBybalances.put(paidBy, 0.0); // add to self as 0
            }
            
            
            paidBybalances.put(paidBy, paidBybalances.get(paidBy) - forEachsplit.getAmount());
            
            System.out.println("B A L A N C E - S H E E T");
            System.out.println(balanceSheet);
        }
        
    }

    public void showBalance(String userId) {
        boolean isEmpty = true;
        for (Map.Entry<String, Double> userBalance : balanceSheet.get(userId).entrySet()) {
            if (userBalance.getValue() != 0) {
                isEmpty = false;
                printBalance(userId, userBalance.getKey(), userBalance.getValue());
            }
        }

        if (isEmpty) {
            System.out.println("No balances");
        }
    }

    public void showBalances() {
        boolean isEmpty = true;
        for (Map.Entry<String, Map<String, Double>> allBalances : balanceSheet.entrySet()) {
            for (Map.Entry<String, Double> userBalance : allBalances.getValue().entrySet()) {
                if (userBalance.getValue() > 0) {
                    isEmpty = false;
                    printBalance(allBalances.getKey(), userBalance.getKey(), userBalance.getValue());
                }
            }
        }

        if (isEmpty) {
            System.out.println("No balances");
        }
    }

    private void printBalance(String user1, String user2, double amount) {
        String user1Name = userMap.get(user1).getName();
        String user2Name = userMap.get(user2).getName();
        if (amount < 0) {
            System.out.println(user1Name + " owes " + user2Name + ": " + Math.abs(amount));
        } else if (amount > 0) {
            System.out.println(user2Name + " owes " + user1Name + ": " + Math.abs(amount));
        }
    }
}