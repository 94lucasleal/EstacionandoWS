package com.lucas.senac.bean;

import javax.xml.bind.annotation.XmlRootElement;

public class Servico {

    private Integer idservico;
    private Integer idestabelecimento;
    private String nome;
    private String descricao;
    private double preco;


    public Servico() {
    }

    public Servico(Integer idservico, Integer idestabelecimento, String nome, String descricao, double preco) {
        this.idservico = idservico;
        this.idestabelecimento = idestabelecimento;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Integer getIdservico() {
        return idservico;
    }

    public void setIdservico(Integer idservico) {
        this.idservico = idservico;
    }

    public Integer getIdestabelecimento() {
        return idestabelecimento;
    }

    public void setIdestabelecimento(Integer idestabelecimento) {
        this.idestabelecimento = idestabelecimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Servico{" + "idservico=" + idservico + ", idestabelecimento=" + idestabelecimento + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + '}';
    }
   
}
