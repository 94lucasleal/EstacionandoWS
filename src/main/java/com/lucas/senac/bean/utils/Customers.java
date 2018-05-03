package com.lucas.senac.bean.utils;

import java.util.List;

public class Customers {

    private String documentNumber;
    private String name;
    private String email;
    private List<Endereco> addresses = null;
    private List<Telefone> phones = null;

    public Customers() {
    }

    public Customers(String documentNumber, String name, String email) {
        this.documentNumber = documentNumber;
        this.name = name;
        this.email = email;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Endereco> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Endereco> addresses) {
        this.addresses = addresses;
    }

    public List<Telefone> getPhones() {
        return phones;
    }

    public void setPhones(List<Telefone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "Customers{" + "documentNumber=" + documentNumber + ", name=" + name + ", email=" + email + ", addresses=" + addresses + ", phones=" + phones + '}';
    }
}
