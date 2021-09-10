package com.example.juc.learn.exercise.sync;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 账户.
 */

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Account {

    // 封装账户编号、账户余额的两个成员变量
    private String accountNo;
    private double balance;



    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
