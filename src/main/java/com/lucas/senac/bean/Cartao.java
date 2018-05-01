package com.lucas.senac.bean;

public class Cartao {

    private int idestabelecimento;
    private int idusuario;
    private String product_id;
    private Double value;
    private String token;
    private int parcels;

    public Cartao() {
    }

    public Cartao(int idestabelecimento, int idusuario, String product_id, Double value, String token, int parcels) {
        this.idestabelecimento = idestabelecimento;
        this.idusuario = idusuario;
        this.product_id = product_id;
        this.value = value;
        this.token = token;
        this.parcels = parcels;
    }

    public int getIdestabelecimento() {
        return idestabelecimento;
    }

    public void setIdestabelecimento(int idestabelecimento) {
        this.idestabelecimento = idestabelecimento;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
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
        return "Cartao{" + "idestabelecimento=" + idestabelecimento + ", idusuario=" + idusuario + ", product_id=" + product_id + ", value=" + value + ", token=" + token + ", parcels=" + parcels + '}';
    }    
}
