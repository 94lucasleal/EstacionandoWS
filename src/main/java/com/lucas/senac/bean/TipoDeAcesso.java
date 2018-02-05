package com.lucas.senac.bean;

public class TipoDeAcesso {

    private Integer idTipoAcesso;
    private String descricao;

    public TipoDeAcesso() {
    }

    public TipoDeAcesso(Integer idTipoAcesso, String descricao) {
        this.idTipoAcesso = idTipoAcesso;
        this.descricao = descricao;
    }

    public Integer getIdTipoAcesso() {
        return idTipoAcesso;
    }

    public void setIdTipoAcesso(Integer idTipoAcesso) {
        this.idTipoAcesso = idTipoAcesso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "TipoDeAcesso{" + "idTipoAcesso=" + idTipoAcesso + ", descricao=" + descricao + '}';
    }

}
