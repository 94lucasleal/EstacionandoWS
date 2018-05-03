package com.lucas.senac.bean.utils;

public class Cartao {

    private String object;
    private String id;
    private String dateCreated;
    private String dateUpdated;
    private String brand;
    private String holderName;
    private String firstDigits;
    private String lastDigits;
    private String country;
    private String fingerprint;
    private Boolean valid;
    private String expirationDate;

    public Cartao() {
    }

    public Cartao(String object, String id, String dateCreated, String dateUpdated, String brand, String holderName, String firstDigits, String lastDigits, String country, String fingerprint, Boolean valid, String expirationDate) {
        this.object = object;
        this.id = id;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.brand = brand;
        this.holderName = holderName;
        this.firstDigits = firstDigits;
        this.lastDigits = lastDigits;
        this.country = country;
        this.fingerprint = fingerprint;
        this.valid = valid;
        this.expirationDate = expirationDate;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
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

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Cartao{" + "object=" + object + ", id=" + id + ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + ", brand=" + brand + ", holderName=" + holderName + ", firstDigits=" + firstDigits + ", lastDigits=" + lastDigits + ", country=" + country + ", fingerprint=" + fingerprint + ", valid=" + valid + ", expirationDate=" + expirationDate + '}';
    }
}
