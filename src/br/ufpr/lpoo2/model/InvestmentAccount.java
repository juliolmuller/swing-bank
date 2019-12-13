package br.ufpr.lpoo2.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InvestmentAccount extends Account {

    private double minBalance;
    private double minDeposit;
    private double initialDeposit;

    public InvestmentAccount(Customer owner, int accNumber, double balance, double initialDeposit, double numBalance,
            double minDeposit) {
        super(owner, accNumber, balance);
        this.minBalance = numBalance;
        this.minDeposit = minDeposit;
        this.initialDeposit = initialDeposit;
    }

    @Override
    public void pay() {
        BigDecimal bigValue = BigDecimal.valueOf((this.getBalance() * 0.02));
        bigValue.setScale(2, RoundingMode.FLOOR);
        if (bigValue.signum() == -1)
            bigValue = bigValue.negate();
        super.setBalance((this.getBalance() + bigValue.doubleValue()));
    }

    @Override
    public boolean withdraw(double value) {
        if (value < 0)
            throw new RuntimeException("Valor inválido (valor negativo)");
        if (this.getBalance() - value >= this.minBalance) {
            super.withdraw(value);
            return true;
        }
        return false;
    }

    @Override
    public boolean deposit(double value) {
        if (value < 0)
            throw new RuntimeException("Valor inválido (valor negativo)");
        if (value >= this.minDeposit) {
            super.deposit(value);
            return true;
        }
        return false;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public double getMinDeposit() {
        return minDeposit;
    }

    public void setMinDeposit(double minDeposit) {
        this.minDeposit = minDeposit;
    }

    public double getInitialDeposit() {
        return initialDeposit;
    }

    public void setInitialDeposit(double initialDeposit) {
        this.initialDeposit = initialDeposit;
    }
}
