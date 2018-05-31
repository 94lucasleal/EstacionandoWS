package com.lucas.senac.bean;

import com.lucas.senac.bean.utils.Customers;
import java.util.Date;
import me.pagar.model.Customer;

public class Pagamento {

    private Integer idpagamento;
    private Integer idestabelecimento;
    private Integer idusuario;
    private Double value;
    private String token;
    private int parcels;
    private String dta_entrada;
    private String dta_saida;
    private Customers customer;

    public Pagamento() {
    }

    public Pagamento(Integer idpagamento, Integer idestabelecimento, Integer idusuario, Double value, String token, int parcels, String dta_entrada, String dta_saida, Customers customer) {
        this.idpagamento = idpagamento;
        this.idestabelecimento = idestabelecimento;
        this.idusuario = idusuario;
        this.value = value;
        this.token = token;
        this.parcels = parcels;
        this.dta_entrada = dta_entrada;
        this.dta_saida = dta_saida;
        this.customer = customer;
    }

    public Integer getIdpagamento() {
        return idpagamento;
    }

    public void setIdpagamento(Integer idpagamento) {
        this.idpagamento = idpagamento;
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

    public String getDta_entrada() {
        return dta_entrada;
    }

    public void setDta_entrada(String dta_entrada) {
        this.dta_entrada = dta_entrada;
    }

    public String getDta_saida() {
        return dta_saida;
    }

    public void setDta_saida(String dta_saida) {
        this.dta_saida = dta_saida;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "idpagamento=" + idpagamento + ", idestabelecimento=" + idestabelecimento + ", idusuario=" + idusuario + ", value=" + value + ", token=" + token + ", parcels=" + parcels + ", dta_entrada=" + dta_entrada + ", dta_saida=" + dta_saida + ", customer=" + customer + '}';
    }

}
