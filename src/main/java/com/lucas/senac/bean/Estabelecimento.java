package com.lucas.senac.bean;

public class Estabelecimento {

    private Integer idestabelecimento;
    private Integer idusuario;
    private Integer idtipoestabelecimento;
    private String razaosocial;
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
    private String imagem;
    private Integer vagastotal;
    private Integer vagasreservada;
    private Integer vagasdisponivel;
    private String entrada_segunda;
    private String entrada_terca;
    private String entrada_quarta;
    private String entrada_quinta;
    private String entrada_sexta;
    private String entrada_sabado;
    private String entrada_domingo;
    private String saida_segunda;
    private String saida_terca;
    private String saida_quarta;
    private String saida_quinta;
    private String saida_sexta;
    private String saida_sabado;
    private String saida_domingo;

    public Estabelecimento() {
    }

    public Estabelecimento(Integer idestabelecimento, Integer idusuario, Integer idtipoestabelecimento, String razaosocial, String cnpj, String estado, String municipio, String bairro, String logradouro, Integer cep, Integer numero, String referencia, Double latitude, Double longitude, Double valormeiahora, Double valorhora, Double valordiaria, Double valormensal, Double valoradicional, String imagem, Integer vagastotal, Integer vagasreservada, Integer vagasdisponivel, String entrada_segunda, String entrada_terca, String entrada_quarta, String entrada_quinta, String entrada_sexta, String entrada_sabado, String entrada_domingo, String saida_segunda, String saida_terca, String saida_quarta, String saida_quinta, String saida_sexta, String saida_sabado, String saida_domingo) {
        this.idestabelecimento = idestabelecimento;
        this.idusuario = idusuario;
        this.idtipoestabelecimento = idtipoestabelecimento;
        this.razaosocial = razaosocial;
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
        this.vagastotal = vagastotal;
        this.vagasreservada = vagasreservada;
        this.vagasdisponivel = vagasdisponivel;
        this.entrada_segunda = entrada_segunda;
        this.entrada_terca = entrada_terca;
        this.entrada_quarta = entrada_quarta;
        this.entrada_quinta = entrada_quinta;
        this.entrada_sexta = entrada_sexta;
        this.entrada_sabado = entrada_sabado;
        this.entrada_domingo = entrada_domingo;
        this.saida_segunda = saida_segunda;
        this.saida_terca = saida_terca;
        this.saida_quarta = saida_quarta;
        this.saida_quinta = saida_quinta;
        this.saida_sexta = saida_sexta;
        this.saida_sabado = saida_sabado;
        this.saida_domingo = saida_domingo;
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

    public Integer getIdtipoestabelecimento() {
        return idtipoestabelecimento;
    }

    public void setIdtipoestabelecimento(Integer idtipoestabelecimento) {
        this.idtipoestabelecimento = idtipoestabelecimento;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
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

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Integer getVagastotal() {
        return vagastotal;
    }

    public void setVagastotal(Integer vagastotal) {
        this.vagastotal = vagastotal;
    }

    public Integer getVagasreservada() {
        return vagasreservada;
    }

    public void setVagasreservada(Integer vagasreservada) {
        this.vagasreservada = vagasreservada;
    }

    public Integer getVagasdisponivel() {
        return vagasdisponivel;
    }

    public void setVagasdisponivel(Integer vagasdisponivel) {
        this.vagasdisponivel = vagasdisponivel;
    }

    public String getEntrada_segunda() {
        return entrada_segunda;
    }

    public void setEntrada_segunda(String entrada_segunda) {
        this.entrada_segunda = entrada_segunda;
    }

    public String getEntrada_terca() {
        return entrada_terca;
    }

    public void setEntrada_terca(String entrada_terca) {
        this.entrada_terca = entrada_terca;
    }

    public String getEntrada_quarta() {
        return entrada_quarta;
    }

    public void setEntrada_quarta(String entrada_quarta) {
        this.entrada_quarta = entrada_quarta;
    }

    public String getEntrada_quinta() {
        return entrada_quinta;
    }

    public void setEntrada_quinta(String entrada_quinta) {
        this.entrada_quinta = entrada_quinta;
    }

    public String getEntrada_sexta() {
        return entrada_sexta;
    }

    public void setEntrada_sexta(String entrada_sexta) {
        this.entrada_sexta = entrada_sexta;
    }

    public String getEntrada_sabado() {
        return entrada_sabado;
    }

    public void setEntrada_sabado(String entrada_sabado) {
        this.entrada_sabado = entrada_sabado;
    }

    public String getEntrada_domingo() {
        return entrada_domingo;
    }

    public void setEntrada_domingo(String entrada_domingo) {
        this.entrada_domingo = entrada_domingo;
    }

    public String getSaida_segunda() {
        return saida_segunda;
    }

    public void setSaida_segunda(String saida_segunda) {
        this.saida_segunda = saida_segunda;
    }

    public String getSaida_terca() {
        return saida_terca;
    }

    public void setSaida_terca(String saida_terca) {
        this.saida_terca = saida_terca;
    }

    public String getSaida_quarta() {
        return saida_quarta;
    }

    public void setSaida_quarta(String saida_quarta) {
        this.saida_quarta = saida_quarta;
    }

    public String getSaida_quinta() {
        return saida_quinta;
    }

    public void setSaida_quinta(String saida_quinta) {
        this.saida_quinta = saida_quinta;
    }

    public String getSaida_sexta() {
        return saida_sexta;
    }

    public void setSaida_sexta(String saida_sexta) {
        this.saida_sexta = saida_sexta;
    }

    public String getSaida_sabado() {
        return saida_sabado;
    }

    public void setSaida_sabado(String saida_sabado) {
        this.saida_sabado = saida_sabado;
    }

    public String getSaida_domingo() {
        return saida_domingo;
    }

    public void setSaida_domingo(String saida_domingo) {
        this.saida_domingo = saida_domingo;
    }

    @Override
    public String toString() {
        return "Estabelecimento{" + "idestabelecimento=" + idestabelecimento + ", idusuario=" + idusuario + ", idtipoestabelecimento=" + idtipoestabelecimento + ", razaosocial=" + razaosocial + ", cnpj=" + cnpj + ", estado=" + estado + ", municipio=" + municipio + ", bairro=" + bairro + ", logradouro=" + logradouro + ", cep=" + cep + ", numero=" + numero + ", referencia=" + referencia + ", latitude=" + latitude + ", longitude=" + longitude + ", valormeiahora=" + valormeiahora + ", valorhora=" + valorhora + ", valordiaria=" + valordiaria + ", valormensal=" + valormensal + ", valoradicional=" + valoradicional + ", vagastotal=" + vagastotal + ", vagasreservada=" + vagasreservada + ", vagasdisponivel=" + vagasdisponivel + ", entrada_segunda=" + entrada_segunda + ", entrada_terca=" + entrada_terca + ", entrada_quarta=" + entrada_quarta + ", entrada_quinta=" + entrada_quinta + ", entrada_sexta=" + entrada_sexta + ", entrada_sabado=" + entrada_sabado + ", entrada_domingo=" + entrada_domingo + ", saida_segunda=" + saida_segunda + ", saida_terca=" + saida_terca + ", saida_quarta=" + saida_quarta + ", saida_quinta=" + saida_quinta + ", saida_sexta=" + saida_sexta + ", saida_sabado=" + saida_sabado + ", saida_domingo=" + saida_domingo + '}';
    }

}
