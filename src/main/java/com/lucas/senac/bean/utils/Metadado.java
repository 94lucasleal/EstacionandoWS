package com.lucas.senac.bean.utils;

public class Metadado {

    private Double idProduto;

    public Metadado() {
    }

    public Metadado(Double idProduto) {
        this.idProduto = idProduto;
    }

    public Double getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Double idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public String toString() {
        return "Metadata{" + "idProduto=" + idProduto + '}';
    }
}
