package com.lucas.senac.bean.utils;

public class Cartao {

    private String id;
    private String brand;
    private String holderName;
    private String firstDigits;
    private String lastDigits;
    private String country;
    private Boolean valid;
    
    public Cartao() {
    }

    public Cartao(String id, String brand, String holderName, String firstDigits, String lastDigits, String country, Boolean valid) {
        this.id = id;
        this.brand = brand;
        this.holderName = holderName;
        this.firstDigits = firstDigits;
        this.lastDigits = lastDigits;
        this.country = country;
        this.valid = valid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getFirstDigits() {
        return firstDigits;
    }

    public void setFirstDigits(String firstDigits) {
        this.firstDigits = firstDigits;
    }

    public String getLastDigits() {
        return lastDigits;
    }

    public void setLastDigits(String lastDigits) {
        this.lastDigits = lastDigits;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "Cartao{" + "id=" + id + ", brand=" + brand + ", holderName=" + holderName + ", firstDigits=" + firstDigits + ", lastDigits=" + lastDigits + ", country=" + country + ", valid=" + valid + '}';
    }
}
