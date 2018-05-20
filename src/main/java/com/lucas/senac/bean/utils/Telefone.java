package com.lucas.senac.bean.utils;

public class Telefone {

    private String ddi;
    private String ddd;
    private String number;

    public Telefone() {
    }

    public Telefone(String ddi, String ddd, String number) {
        this.ddi = ddi;
        this.ddd = ddd;
        this.number = number;
    }

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        this.ddi = ddi;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Phone{" + "ddi=" + ddi + ", ddd=" + ddd + ", number=" + number + '}';
    }
}