package br.ufpr.lpoo2.model;

import java.time.LocalDate;

public class Contact {

    private Long id;
    private String name;
    private String email;
    private String address;
    private LocalDate dateBirth;

    public Contact(Long id, String name, String email, String address, LocalDate dateBirth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.dateBirth = dateBirth;
    }

    public void clone(Contact contact) {
        this.name = contact.name;
        this.email = contact.email;
        this.address = contact.address;
        this.dateBirth = contact.dateBirth;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setNome(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateBirth() {
        return this.dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }
}
