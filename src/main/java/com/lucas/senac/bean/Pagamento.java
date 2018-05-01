package com.lucas.senac.bean;

import java.sql.Date;

public class Pagamento {

    private int idpagamento;
    private int idestabelecimento;
    private int idusuario;
    private String product_id;
    //Valor, em centavos, da transação.
    private int amount;
    //Número de parcelas a serem cobradas.
    private int installments;
    //Código que identifica a transação na adquirente.
    private String nsu;
    //Código que identifica a transação na adquirente.
    private String tid;
    //Código de autorização retornado pela bandeira.
    private String authorization_code;
    //Valores possíveis: development (em ambiente de testes), pagarme (adquirente Pagar.me), stone, cielo, rede.
    private String acquirer_name;
    //Método de pagamento, com os possíveis valores: credit_card e boleto
    private String payment_method;
    //Valores possíveis: processing, authorized, paid, refunded, waiting_payment, pending_refund, refused .
    private String status;
    //Valores possíveis: acquirer, antifraud, internal_error, no_acquirer, acquirer_timeout
    private String refuse_reason;
    //Valores possíveis: acquirer, antifraud, internal_error, no_acquirer, acquirer_timeout
    private String status_reason;
    //Bandeira do cartão.
    private String card_brand;
    private String date_updated;
    private String date_created;
    private String boleto_url;
    private String boleto_barcode;
    private Date dta_pagamento;
    private Date dta_entrada;
    private Date dta_saida;

    public Pagamento() {
    }

    public Pagamento(int idpagamento, int idestabelecimento, int idusuario, String product_id, int amount, int installments, String nsu, String tid, String authorization_code, String acquirer_name, String payment_method, String status, String refuse_reason, String status_reason, String card_brand, String date_updated, String date_created, String boleto_url, String boleto_barcode, Date dta_pagamento, Date dta_entrada, Date dta_saida) {
        this.idpagamento = idpagamento;
        this.idestabelecimento = idestabelecimento;
        this.idusuario = idusuario;
        this.product_id = product_id;
        this.amount = amount;
        this.installments = installments;
        this.nsu = nsu;
        this.tid = tid;
        this.authorization_code = authorization_code;
        this.acquirer_name = acquirer_name;
        this.payment_method = payment_method;
        this.status = status;
        this.refuse_reason = refuse_reason;
        this.status_reason = status_reason;
        this.card_brand = card_brand;
        this.date_updated = date_updated;
        this.date_created = date_created;
        this.boleto_url = boleto_url;
        this.boleto_barcode = boleto_barcode;
        this.dta_pagamento = dta_pagamento;
        this.dta_entrada = dta_entrada;
        this.dta_saida = dta_saida;
    }

    public int getIdpagamento() {
        return idpagamento;
    }

    public void setIdpagamento(int idpagamento) {
        this.idpagamento = idpagamento;
    }

    public int getIdestabelecimento() {
        return idestabelecimento;
    }

    public void setIdestabelecimento(int idestabelecimento) {
        this.idestabelecimento = idestabelecimento;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getInstallments() {
        return installments;
    }

    public void setInstallments(int installments) {
        this.installments = installments;
    }

    public String getNsu() {
        return nsu;
    }

    public void setNsu(String nsu) {
        this.nsu = nsu;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getAuthorization_code() {
        return authorization_code;
    }

    public void setAuthorization_code(String authorization_code) {
        this.authorization_code = authorization_code;
    }

    public String getAcquirer_name() {
        return acquirer_name;
    }

    public void setAcquirer_name(String acquirer_name) {
        this.acquirer_name = acquirer_name;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRefuse_reason() {
        return refuse_reason;
    }

    public void setRefuse_reason(String refuse_reason) {
        this.refuse_reason = refuse_reason;
    }

    public String getStatus_reason() {
        return status_reason;
    }

    public void setStatus_reason(String status_reason) {
        this.status_reason = status_reason;
    }

    public String getCard_brand() {
        return card_brand;
    }

    public void setCard_brand(String card_brand) {
        this.card_brand = card_brand;
    }

    public String getDate_updated() {
        return date_updated;
    }

    public void setDate_updated(String date_updated) {
        this.date_updated = date_updated;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getBoleto_url() {
        return boleto_url;
    }

    public void setBoleto_url(String boleto_url) {
        this.boleto_url = boleto_url;
    }

    public String getBoleto_barcode() {
        return boleto_barcode;
    }

    public void setBoleto_barcode(String boleto_barcode) {
        this.boleto_barcode = boleto_barcode;
    }

    public Date getDta_pagamento() {
        return dta_pagamento;
    }

    public void setDta_pagamento(Date dta_pagamento) {
        this.dta_pagamento = dta_pagamento;
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
        return "Pagamento{" + "idpagamento=" + idpagamento + ", idestabelecimento=" + idestabelecimento + ", idusuario=" + idusuario + ", product_id=" + product_id + ", amount=" + amount + ", installments=" + installments + ", nsu=" + nsu + ", tid=" + tid + ", authorization_code=" + authorization_code + ", acquirer_name=" + acquirer_name + ", payment_method=" + payment_method + ", status=" + status + ", refuse_reason=" + refuse_reason + ", status_reason=" + status_reason + ", card_brand=" + card_brand + ", date_updated=" + date_updated + ", date_created=" + date_created + ", boleto_url=" + boleto_url + ", boleto_barcode=" + boleto_barcode + ", dta_pagamento=" + dta_pagamento + ", dta_entrada=" + dta_entrada + ", dta_saida=" + dta_saida + '}';
    }
}
