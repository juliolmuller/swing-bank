package br.ufpr.lpoo2.model;

public interface AccountInterface {

    boolean deposit(double valor);
    boolean withdraw(double valor);
    Customer getOwner();
    int getNumber();
    double getBalance();
    void pay();
}
