package com.lucas.senac.bean;

public class Pagamento {

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

    public Pagamento() {
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

    @Override
    public String toString() {
        return "Pagamento{" + "amount=" + amount + ", installments=" + installments + ", nsu=" + nsu + ", tid=" + tid + ", authorization_code=" + authorization_code + ", acquirer_name=" + acquirer_name + ", payment_method=" + payment_method + ", status=" + status + ", refuse_reason=" + refuse_reason + ", status_reason=" + status_reason + ", card_brand=" + card_brand + ", date_updated=" + date_updated + ", date_created=" + date_created + ", boleto_url=" + boleto_url + ", boleto_barcode=" + boleto_barcode + '}';
    }   

}
