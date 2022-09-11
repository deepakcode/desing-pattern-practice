package com.practice.lld.splitwise.models.split;

import com.practice.lld.splitwise.models.User;

public class ExactSplit extends Split {

    public ExactSplit(User user, double amount) {
        super(user);
        this.amount = amount;
    }
}