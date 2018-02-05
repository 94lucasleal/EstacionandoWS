package com.lucas.senac.bean;

public class Estabelecimento {

    private Integer idEstacionamento;
    private Integer idUsuario;
    private Integer idTipoEstabelecimento;
    private String razaoSocial;
    private String cnpj;
    private String estado;
    private String municipio;
    private String bairro;
    private String logradouro;
    private Integer cep;
    private Integer numero;
    private String referencia;
    private Double latitude;
    private Double longitude;
    private Double valormeiahora;
    private Double valorhora;
    private Double valordiaria;
    private Double valormensal;
    private Double valoradicional;
    private Integer imagem;

    public Estabelecimento() {
    }

    public Estabelecimento(Integer idEstacionamento, Integer idUsuario, Integer idTipoEstabelecimento, String razaoSocial, String cnpj, String estado, String municipio, String bairro, String logradouro, Integer cep, Integer numero, String referencia, Double latitude, Double longitude, Double valormeiahora, Double valorhora, Double valordiaria, Double valormensal, Double valoradicional, Integer imagem) {
        this.idEstacionamento = idEstacionamento;
        this.idUsuario = idUsuario;
        this.idTipoEstabelecimento = idTipoEstabelecimento;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.estado = estado;
        this.municipio = municipio;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.referencia = referencia;
        this.latitude = latitude;
        this.longitude = longitude;
        this.valormeiahora = valormeiahora;
        this.valorhora = valorhora;
        this.valordiaria = valordiaria;
        this.valormensal = valormensal;
        this.valoradicional = valoradicional;
        this.imagem = imagem;
    }

    public Integer getIdEstacionamento() {
        return idEstacionamento;
    }

    public void setIdEstacionamento(Integer idEstacionamento) {
        this.idEstacionamento = idEstacionamento;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdTipoEstabelecimento() {
        return idTipoEstabelecimento;
    }

    public void setIdTipoEstabelecimento(Integer idTipoEstabelecimento) {
        this.idTipoEstabelecimento = idTipoEstabelecimento;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getValormeiahora() {
        return valormeiahora;
    }

    public void setValormeiahora(Double valormeiahora) {
        this.valormeiahora = valormeiahora;
    }

    public Double getValorhora() {
        return valorhora;
    }

    public void setValorhora(Double valorhora) {
        this.valorhora = valorhora;
    }

    public Double getValordiaria() {
        return valordiaria;
    }

    public void setValordiaria(Double valordiaria) {
        this.valordiaria = valordiaria;
    }

    public Double getValormensal() {
        return valormensal;
    }

    public void setValormensal(Double valormensal) {
        this.valormensal = valormensal;
    }

    public Double getValoradicional() {
        return valoradicional;
    }

    public void setValoradicional(Double valoradicional) {
        this.valoradicional = valoradicional;
    }

    public Integer getImagem() {
        return imagem;
    }

    public void setImagem(Integer imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return "Estabelecimento{" + "idEstacionamento=" + idEstacionamento + ", idUsuario=" + idUsuario + ", idTipoEstabelecimento=" + idTipoEstabelecimento + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", estado=" + estado + ", municipio=" + municipio + ", bairro=" + bairro + ", logradouro=" + logradouro + ", cep=" + cep + ", numero=" + numero + ", referencia=" + referencia + ", latitude=" + latitude + ", longitude=" + longitude + ", valormeiahora=" + valormeiahora + ", valorhora=" + valorhora + ", valordiaria=" + valordiaria + ", valormensal=" + valormensal + ", valoradicional=" + valoradicional + ", imagem=" + imagem + '}';
    }

}
