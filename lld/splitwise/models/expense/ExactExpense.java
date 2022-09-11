
package com.practice.lld.splitwise.models.expense;

import com.practice.lld.splitwise.models.User;
import com.practice.lld.splitwise.models.split.ExactSplit;
import com.practice.lld.splitwise.models.split.Split;

import java.util.List;

public class ExactExpense extends Expense {
    public ExactExpense(double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
        super(amount, paidBy, splits, expenseMetadata);
    }

    @Override
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof ExactSplit)) {
                return false;
            }
        }

        double totalAmount = getAmount();
        double sumSplitAmount = 0;
        for (Split split : getSplits()) {
            ExactSplit exactSplit = (ExactSplit) split;
            sumSplitAmount += exactSplit.getAmount();
        }

        if (totalAmount != sumSplitAmount) {
            return false;
        }

        return true;
    }
}