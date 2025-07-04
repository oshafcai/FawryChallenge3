/**
 * Author: Nadra Mahmoud Saad
 * Date: July 4, 2025
 *
 * This class represents a customer with a name and balance.
 * It provides functionality to deduct payment and check if
 * the customer can afford a given amount.
 *
 * SOLID Principles:
 * - SRP: Only responsible for customer financial data and operations.
 *
 * Corner Cases Handled:
 * - Prevents balance from dropping below zero.
 */
package com.example.fawrychallenge3;
public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public boolean canPay(double amount) {
        return balance >= amount;
    }

    public void deduct(double amount) {
        if (amount > balance) throw new IllegalStateException("Insufficient funds.");
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }
}
