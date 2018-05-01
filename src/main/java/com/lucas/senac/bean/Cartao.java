package com.lucas.senac.bean;

public class Cartao {

    private int idestabelecimento;
    private int idusuario;
    private String idcartao;
    private Double value;
    private String token;
    private int parcels;

    public Cartao() {
    }

    public Cartao(int idestabelecimento, int idusuario, String idcartao, Double value, String token, int parcels) {
        this.idestabelecimento = idestabelecimento;
        this.idusuario = idusuario;
        this.idcartao = idcartao;
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

    public String getIdcartao() {
        return idcartao;
    }

    public void setIdcartao(String idcartao) {
        this.idcartao = idcartao;
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
        return "Cartao{" + "idestabelecimento=" + idestabelecimento + ", idusuario=" + idusuario + ", idcartao=" + idcartao + ", value=" + value + ", token=" + token + ", parcels=" + parcels + '}';
    }
    
}
