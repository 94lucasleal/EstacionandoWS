package com.lucas.senac.bean;

public class Favoritos {

    private Integer idestabelecimento;
    private Integer idusuario;
    private char ativo;

    public Favoritos() {
    }

    public Favoritos(Integer idestabelecimento, Integer idusuario, char ativo) {
        this.idestabelecimento = idestabelecimento;
        this.idusuario = idusuario;
        this.ativo = ativo;
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

    public char getAtivo() {
        return ativo;
    }

    public void setAtivo(char ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Favoritos{" +
                "idestabelecimento=" + idestabelecimento +
                ", idusuario=" + idusuario +
                ", ativo=" + ativo +
                '}';
    }
}
