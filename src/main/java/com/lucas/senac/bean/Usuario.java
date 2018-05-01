package com.lucas.senac.bean;

import java.util.Arrays;
import javax.xml.bind.annotation.XmlRootElement;

public class Usuario {

    private Integer idUsuario;
    private String nome;
    private String cpf;
    private String rg;
    private String email;
    private String senha;
    private Integer idTipoAcesso;
    private long telefone;
    private String imagem;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String nome, String cpf, String rg, String email, String senha, Integer idTipoAcesso, long telefone, String imagem) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.senha = senha;
        this.idTipoAcesso = idTipoAcesso;
        this.telefone = telefone;
        this.imagem = imagem;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getIdTipoAcesso() {
        return idTipoAcesso;
    }

    public void setIdTipoAcesso(Integer idTipoAcesso) {
        this.idTipoAcesso = idTipoAcesso;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", email=" + email + ", senha=" + senha + ", idTipoAcesso=" + idTipoAcesso + ", telefone=" + telefone + '}';
    }
    
    

}
