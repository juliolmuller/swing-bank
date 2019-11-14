package br.ufpr.lpoo2.model;

import java.time.LocalDate;

public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateBirth;
    private String address;
    private String rg;
    private String cpf;

    public Customer() {}

    public Customer(Long id, String firstName, String lastName, LocalDate dateBirth, String address, String rg, String cpf) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateBirth = dateBirth;
        this.address = address;
        this.rg = rg;
        this.cpf = cpf;
    }

    public void clone(Customer customer) {
        this.firstName = customer.firstName;
        this.lastName = customer.lastName;
        this.dateBirth = customer.dateBirth;
        this.address = customer.address;
        this.rg = customer.rg;
        this.cpf = customer.cpf;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateBirth() {
        return this.dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRG() {
        return this.rg;
    }

    public void setRG(String rg) {
        this.rg = rg;
    }

    public String getCPF() {
        return this.cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }
}
