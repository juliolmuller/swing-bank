package br.ufpr.lpoo2.model;

public class Customer {

    private Integer id;
    private String firstName;
    private String lastName;
    private String rg;
    private String cpf;
    private String address;

    public Customer() {}

    public Customer(Integer id, String firstName, String lastName, String rg, String cpf, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rg = rg;
        this.cpf = cpf;
        this.address = address;
    }

    public void clone(Customer customer) {
        this.firstName = customer.firstName;
        this.lastName = customer.lastName;
        this.rg = customer.rg;
        this.cpf = customer.cpf;
        this.address = customer.address;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
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

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
