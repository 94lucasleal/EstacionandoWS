package com.lucas.senac.bean;

import java.util.Date;

public class Historico {

    private int idhistorico;
    private Estabelecimento estabelecimento;
    private Usuario usuario;
    private Transacao trancasao;
    private Date dta_entrada;
    private Date dta_saida;

    public Historico() {
    }

    public Historico(int idhistorico, Estabelecimento estabelecimento, Usuario usuario, Transacao trancasao, Date dta_entrada, Date dta_saida) {
        this.idhistorico = idhistorico;
        this.estabelecimento = estabelecimento;
        this.usuario = usuario;
        this.trancasao = trancasao;
        this.dta_entrada = dta_entrada;
        this.dta_saida = dta_saida;
    }

    public int getIdhistorico() {
        return idhistorico;
    }

    public void setIdhistorico(int idhistorico) {
        this.idhistorico = idhistorico;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Transacao getTrancasao() {
        return trancasao;
    }

    public void setTrancasao(Transacao trancasao) {
        this.trancasao = trancasao;
    }

    public Date getDta_entrada() {
        return dta_entrada;
    }

    public void setDta_entrada(Date dta_entrada) {
        this.dta_entrada = dta_entrada;
    }

    public Date getDta_saida() {
        return dta_saida;
    }

    public void setDta_saida(Date dta_saida) {
        this.dta_saida = dta_saida;
    }

    @Override
    public String toString() {
        return "Historico{" + "idhistorico=" + idhistorico + ", estabelecimento=" + estabelecimento + ", usuario=" + usuario + ", trancasao=" + trancasao + ", dta_entrada=" + dta_entrada + ", dta_saida=" + dta_saida + '}';
    }

}
