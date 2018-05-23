package com.lucas.senac.bean;

public class Carteira {

    private Integer idcarteira;
    private Integer idusuario;
    private float saldo_disponivel;
    private float saldo_pendente;

    public Carteira() {
    }

    public Carteira(Integer idcarteira, Integer idusuario, float saldo_disponivel, float saldo_pendente) {
        this.idcarteira = idcarteira;
        this.idusuario = idusuario;
        this.saldo_disponivel = saldo_disponivel;
        this.saldo_pendente = saldo_pendente;
    }

    public Integer getIdcarteira() {
        return idcarteira;
    }

    public void setIdcarteira(Integer idcarteira) {
        this.idcarteira = idcarteira;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public float getSaldo_disponivel() {
        return saldo_disponivel;
    }

    public void setSaldo_disponivel(float saldo_disponivel) {
        this.saldo_disponivel = saldo_disponivel;
    }

    public float getSaldo_pendente() {
        return saldo_pendente;
    }

    public void setSaldo_pendente(float saldo_pendente) {
        this.saldo_pendente = saldo_pendente;
    }

    @Override
    public String toString() {
        return "Carteira{" + "idcarteira=" + idcarteira + ", idusuario=" + idusuario + ", saldo_disponivel=" + saldo_disponivel + ", saldo_pendente=" + saldo_pendente + '}';
    }

}
