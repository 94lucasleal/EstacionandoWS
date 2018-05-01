package com.lucas.senac.bean;

import java.util.Date;

public class Cartao {

    private Integer idestabelecimento;
    private Integer idusuario;
    private String product_id;
    private Double value;
    private String token;
    private int parcels;
    private Date dta_agendamento;

    public Cartao() {
    }

    public Cartao(Integer idestabelecimento, Integer idusuario, String product_id, Double value, String token, int parcels, Date dta_agendamento) {
        this.idestabelecimento = idestabelecimento;
        this.idusuario = idusuario;
        this.product_id = product_id;
        this.value = value;
        this.token = token;
        this.parcels = parcels;
        this.dta_agendamento = dta_agendamento;
    }

    public Integer getIdestabelecimento() {
        return idestabelecimento;
    }

    public void setIdestabelecimento(Integer idestabelecimento) {
        this.idestabelecimento = idestabelecimento;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
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

    public Date getDta_agendamento() {
        return dta_agendamento;
    }

    public void setDta_agendamento(Date dta_agendamento) {
        this.dta_agendamento = dta_agendamento;
    }

    @Override
    public String toString() {
        return "Cartao{" + "idestabelecimento=" + idestabelecimento + ", idusuario=" + idusuario + ", product_id=" + product_id + ", value=" + value + ", token=" + token + ", parcels=" + parcels + ", dta_agendamento=" + dta_agendamento + '}';
    }
}
