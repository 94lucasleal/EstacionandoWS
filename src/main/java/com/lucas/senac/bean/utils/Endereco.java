package com.lucas.senac.bean.utils;

public class Endereco {

    private String street;
    private String streetNumber;
    private String neighborhood;
    private String zipcode;

    public Endereco() {
    }

    public Endereco(String street, String streetNumber, String neighborhood, String zipcode) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.neighborhood = neighborhood;
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Address{" + "street=" + street + ", streetNumber=" + streetNumber + ", neighborhood=" + neighborhood + ", zipcode=" + zipcode + '}';
    }
}
