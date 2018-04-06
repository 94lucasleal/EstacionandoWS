package com.lucas.senac.bean;

import javax.xml.bind.annotation.XmlRootElement;

public class Upload {

    private int id;
    private byte[] imagem;


    public Upload() {
    }

    public Upload(int id, byte[] imagem) {
        this.id = id;
        this.imagem = imagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

}
