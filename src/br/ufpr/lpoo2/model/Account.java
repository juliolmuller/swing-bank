package br.ufpr.lpoo2.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Account implements AccountInterface{

    private final Customer owner;
    private final int accNumber;
    private double balance;
    private String type;

    public Account(Customer owner, int accNumber, double balance) {
        this.owner = owner;
        this.accNumber = accNumber;
        this.balance = balance;
    }

    public Account(Customer owner, int accNumber, double balance, String type) {
        this.owner = owner;
        this.accNumber = accNumber;
        this.balance = balance;
        this.type = type;
    }

    @Override
    public boolean deposit(double value) {
        if (value > 0){
            BigDecimal bigValue = BigDecimal.valueOf(value);
            BigDecimal bigBalance = BigDecimal.valueOf(this.balance);
            bigBalance = bigBalance.add(bigValue);
            bigBalance = bigBalance.setScale(2, RoundingMode.FLOOR);
            this.balance = bigBalance.doubleValue();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean withdraw(double value) {
        if (value > 0){
            BigDecimal bigValue = BigDecimal.valueOf(value);
            BigDecimal bigBalance = BigDecimal.valueOf(this.balance);
            bigBalance = bigBalance.subtract(bigValue);
            bigBalance = bigBalance.setScale(2, RoundingMode.FLOOR);
            this.balance = bigBalance.doubleValue();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void pay() {}

    @Override
    public Customer getOwner() {
        return this.owner;
    }

    @Override
    public int getNumber() {
        return this.accNumber;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    // FIXME: Remover o método por questao de segurança
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
