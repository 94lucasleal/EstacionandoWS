package com.lucas.senac.bean;

public class Cartao {
    
    /*
    private String id;
    private Double value;
    private String token;
    private int parcels;
    */
    private String item_id;
    private float amount;
    private String currency_id;
    private String payer_email;

    public Cartao() {
    }

    public Cartao(String item_id, float amount, String currency_id, String payer_email) {
        this.item_id = item_id;
        this.amount = amount;
        this.currency_id = currency_id;
        this.payer_email = payer_email;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(String currency_id) {
        this.currency_id = currency_id;
    }

    public String getPayer_email() {
        return payer_email;
    }

    public void setPayer_email(String payer_email) {
        this.payer_email = payer_email;
    }

    @Override
    public String toString() {
        return "Cartao{" + "item_id=" + item_id + ", amount=" + amount + ", currency_id=" + currency_id + ", payer_email=" + payer_email + '}';
    }

   
    
}
