package src.java.model;

public class Account {
    private final int pin;
    private double balance;

    public Account(int pin, double initialBalance) {
        this.pin = pin;
        this.balance = initialBalance;
    }
    public boolean verifyPin(int inputPin) { return this.pin == inputPin; }
    public double getBalance() { return balance; }
    public void deposit(double amount) { balance += amount; }
    public boolean withdraw(double amount) {
        if (amount > balance) return false;
        balance -= amount;
        return true;
    }
}