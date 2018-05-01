package com.lucas.senac.bean;

public class Cartao {

    private String id;
    private Double value;
    private String token;
    private int parcels;

    public Cartao() {
    }

    public Cartao(String id, Double value, String token, int parcels) {
        this.id = id;
        this.value = value;
        this.token = token;
        this.parcels = parcels;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getParcels() {
        return parcels;
    }

    public void setParcels(int parcels) {
        this.parcels = parcels;
    }

    @Override
    public String toString() {
        return "Cartao{" + "id=" + id + ", value=" + value + ", token=" + token + ", parcels=" + parcels + '}';
    }
    
}
