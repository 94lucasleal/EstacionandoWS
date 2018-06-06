package com.lucas.senac.bean;

import java.util.Date;

public class Transacao {

    private Integer idtransacao;
    private Integer idestabelecimento;
    private Integer idusuario;
    private Date dta_entrada;
    private Date dta_saida;
    private Integer id;
    private Integer amount;
    private Integer refunded_amount;
    private Integer authorized_amount;
    private Integer paid_amount;
    private Integer installments;
    private Integer cost;
    private String tid;
    private String nsu;
    private String boleto_url;
    private String boleto_barcode;
    private String referer;
    private String ip;
    private String acquirer_name;
    private String payment_method;
    private String status;
    private String status_reason;
    private String date_updated;
    private String customers_document;
    private String customers_name;
    private String customers_email;
    private String date_created;
    private String cartao_brand;
    private String cartao_first_digits;
    private String cartao_last_digits;
    private String cartao_name;
    private Boolean cartao_valid;
    private String qrcode;
    private String dta_entrada_real;
    private String dta_saida_prevista;
    private String dta_saida_real;
    private Boolean utilizou_reserva;

    public Transacao() {
    }

    public Transacao(Integer idtransacao, Integer idestabelecimento, Integer idusuario, Date dta_entrada, Date dta_saida, Integer id, Integer amount, Integer refunded_amount, Integer authorized_amount, Integer paid_amount, Integer installments, Integer cost, String tid, String nsu, String boleto_url, String boleto_barcode, String referer, String ip, String acquirer_name, String payment_method, String status, String status_reason, String date_updated, String customers_document, String customers_name, String customers_email, String date_created, String cartao_brand, String cartao_first_digits, String cartao_last_digits, String cartao_name, Boolean cartao_valid, String qrcode, String dta_entrada_real, String dta_saida_prevista, String dta_saida_real, Boolean utilizou_reserva) {
        this.idtransacao = idtransacao;
        this.idestabelecimento = idestabelecimento;
        this.idusuario = idusuario;
        this.dta_entrada = dta_entrada;
        this.dta_saida = dta_saida;
        this.id = id;
        this.amount = amount;
        this.refunded_amount = refunded_amount;
        this.authorized_amount = authorized_amount;
        this.paid_amount = paid_amount;
        this.installments = installments;
        this.cost = cost;
        this.tid = tid;
        this.nsu = nsu;
        this.boleto_url = boleto_url;
        this.boleto_barcode = boleto_barcode;
        this.referer = referer;
        this.ip = ip;
        this.acquirer_name = acquirer_name;
        this.payment_method = payment_method;
        this.status = status;
        this.status_reason = status_reason;
        this.date_updated = date_updated;
        this.customers_document = customers_document;
        this.customers_name = customers_name;
        this.customers_email = customers_email;
        this.date_created = date_created;
        this.cartao_brand = cartao_brand;
        this.cartao_first_digits = cartao_first_digits;
        this.cartao_last_digits = cartao_last_digits;
        this.cartao_name = cartao_name;
        this.cartao_valid = cartao_valid;
        this.qrcode = qrcode;
        this.dta_entrada_real = dta_entrada_real;
        this.dta_saida_prevista = dta_saida_prevista;
        this.dta_saida_real = dta_saida_real;
        this.utilizou_reserva = utilizou_reserva;
    }

    public Integer getIdtransacao() {
        return idtransacao;
    }

    public void setIdtransacao(Integer idtransacao) {
        this.idtransacao = idtransacao;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getRefunded_amount() {
        return refunded_amount;
    }

    public void setRefunded_amount(Integer refunded_amount) {
        this.refunded_amount = refunded_amount;
    }

    public Integer getAuthorized_amount() {
        return authorized_amount;
    }

    public void setAuthorized_amount(Integer authorized_amount) {
        this.authorized_amount = authorized_amount;
    }

    public Integer getPaid_amount() {
        return paid_amount;
    }

    public void setPaid_amount(Integer paid_amount) {
        this.paid_amount = paid_amount;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getNsu() {
        return nsu;
    }

    public void setNsu(String nsu) {
        this.nsu = nsu;
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

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

    public String getStatus_reason() {
        return status_reason;
    }

    public void setStatus_reason(String status_reason) {
        this.status_reason = status_reason;
    }

    public String getDate_updated() {
        return date_updated;
    }

    public void setDate_updated(String date_updated) {
        this.date_updated = date_updated;
    }

    public String getCustomers_document() {
        return customers_document;
    }

    public void setCustomers_document(String customers_document) {
        this.customers_document = customers_document;
    }

    public String getCustomers_name() {
        return customers_name;
    }

    public void setCustomers_name(String customers_name) {
        this.customers_name = customers_name;
    }

    public String getCustomers_email() {
        return customers_email;
    }

    public void setCustomers_email(String customers_email) {
        this.customers_email = customers_email;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getCartao_brand() {
        return cartao_brand;
    }

    public void setCartao_brand(String cartao_brand) {
        this.cartao_brand = cartao_brand;
    }

    public String getCartao_first_digits() {
        return cartao_first_digits;
    }

    public void setCartao_first_digits(String cartao_first_digits) {
        this.cartao_first_digits = cartao_first_digits;
    }

    public String getCartao_last_digits() {
        return cartao_last_digits;
    }

    public void setCartao_last_digits(String cartao_last_digits) {
        this.cartao_last_digits = cartao_last_digits;
    }

    public String getCartao_name() {
        return cartao_name;
    }

    public void setCartao_name(String cartao_name) {
        this.cartao_name = cartao_name;
    }

    public Boolean getCartao_valid() {
        return cartao_valid;
    }

    public void setCartao_valid(Boolean cartao_valid) {
        this.cartao_valid = cartao_valid;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getDta_entrada_real() {
        return dta_entrada_real;
    }

    public void setDta_entrada_real(String dta_entrada_real) {
        this.dta_entrada_real = dta_entrada_real;
    }

    public String getDta_saida_prevista() {
        return dta_saida_prevista;
    }

    public void setDta_saida_prevista(String dta_saida_prevista) {
        this.dta_saida_prevista = dta_saida_prevista;
    }

    public String getDta_saida_real() {
        return dta_saida_real;
    }

    public void setDta_saida_real(String dta_saida_real) {
        this.dta_saida_real = dta_saida_real;
    }

    public Boolean getUtilizou_reserva() {
        return utilizou_reserva;
    }

    public void setUtilizou_reserva(Boolean utilizou_reserva) {
        this.utilizou_reserva = utilizou_reserva;
    }

    @Override
    public String toString() {
        return "Transacao{" + "idtransacao=" + idtransacao + ", idestabelecimento=" + idestabelecimento + ", idusuario=" + idusuario + ", dta_entrada=" + dta_entrada + ", dta_saida=" + dta_saida + ", id=" + id + ", amount=" + amount + ", refunded_amount=" + refunded_amount + ", authorized_amount=" + authorized_amount + ", paid_amount=" + paid_amount + ", installments=" + installments + ", cost=" + cost + ", tid=" + tid + ", nsu=" + nsu + ", boleto_url=" + boleto_url + ", boleto_barcode=" + boleto_barcode + ", referer=" + referer + ", ip=" + ip + ", acquirer_name=" + acquirer_name + ", payment_method=" + payment_method + ", status=" + status + ", status_reason=" + status_reason + ", date_updated=" + date_updated + ", customers_document=" + customers_document + ", customers_name=" + customers_name + ", customers_email=" + customers_email + ", date_created=" + date_created + ", cartao_brand=" + cartao_brand + ", cartao_first_digits=" + cartao_first_digits + ", cartao_last_digits=" + cartao_last_digits + ", cartao_name=" + cartao_name + ", cartao_valid=" + cartao_valid + ", qrcode=" + qrcode + ", dta_entrada_real=" + dta_entrada_real + ", dta_saida_prevista=" + dta_saida_prevista + ", dta_saida_real=" + dta_saida_real + ", utilizou_reserva=" + utilizou_reserva + '}';
    }
}
