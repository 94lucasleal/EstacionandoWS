package com.lucas.senac.bean;

public class Feedback {

    private Integer idfeedback;
    private Integer idestabelecimento;
    private String nome;
    private Double nota;
    private String descricao;

    public Feedback() {
    }

    public Integer getIdfeedback() {
        return idfeedback;
    }

    public void setIdfeedback(Integer idfeedback) {
        this.idfeedback = idfeedback;
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

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Feedback{" + "idfeedback=" + idfeedback + ", idestabelecimento=" + idestabelecimento + ", nome=" + nome + ", nota=" + nota + ", descricao=" + descricao + '}';
    }
        
}
