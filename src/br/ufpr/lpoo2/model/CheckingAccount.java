package br.ufpr.lpoo2.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CheckingAccount extends Account {

    private double initialDeposit;
    private double maxLimit;

    public CheckingAccount(Customer owner, int accNumber, double balance, double initialDeposit, double maxLimit) {
        super(owner, accNumber, balance);
        this.initialDeposit = initialDeposit;
        this.maxLimit = maxLimit;
    }

    @Override
    public void pay() {
        BigDecimal bigValue = BigDecimal.valueOf((this.getBalance() * 0.01));
        bigValue.setScale(2, RoundingMode.FLOOR);
        if (bigValue.signum() == -1)
            bigValue = bigValue.negate();
        super.setBalance(this.getBalance() + bigValue.doubleValue());
    }

    @Override
    public boolean withdraw(double value) {
        if (value < 0)
            throw new RuntimeException("Valor negativo é inválido");
        if ((this.getBalance() - value) >= (this.maxLimit * -1)) {
            super.withdraw(value);
            return true;
        }
        return false;
    }

    @Override
    public boolean deposit(double value) {
        if (value < 0)
            throw new RuntimeException("Valor do depósito abaixo de zero");
        return super.deposit(value) == true;
    }

    public double getInitialDeposit() {
        return this.initialDeposit;
    }

    public void setInitialDeposit(int initialDeposit) {
        this.initialDeposit = initialDeposit;
    }

    public double getMaxLimit() {
        return this.maxLimit;
    }

    public void setMaxLimit(int maxLimit) {
        this.maxLimit = maxLimit;
    }
}
