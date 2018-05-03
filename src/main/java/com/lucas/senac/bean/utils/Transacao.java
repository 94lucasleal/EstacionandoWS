package com.lucas.senac.bean.utils;

import com.lucas.senac.bean.utils.Customers;
import java.util.Map;

public class Transacao {

    private Integer id;
    private Integer amount;
    private Integer refundedAmount;
    private Integer authorizedAmount;
    private Integer paidAmount;
    private Integer installments;
    private Integer cost;
    private String tid;
    private String nsu;
    private String boletoUrl;
    private String boletoBarcode;
    private String referer;
    private String ip;
    private String acquirerName;
    private String paymentMethod;
    private String status;
    private String statusReason;
    private String dateUpdated;
    private Customers customer;
    private String dateCreated;
    private Cartao card;

    public Transacao() {
    }

    public Transacao(Integer id, Integer amount, Integer refundedAmount, Integer authorizedAmount, Integer paidAmount, Integer installments, Integer cost, String tid, String nsu, String boletoUrl, String boletoBarcode, String referer, String ip, String acquirerName, String paymentMethod, String status, String statusReason, String dateUpdated, Customers customer, String dateCreated, Cartao card) {
        this.id = id;
        this.amount = amount;
        this.refundedAmount = refundedAmount;
        this.authorizedAmount = authorizedAmount;
        this.paidAmount = paidAmount;
        this.installments = installments;
        this.cost = cost;
        this.tid = tid;
        this.nsu = nsu;
        this.boletoUrl = boletoUrl;
        this.boletoBarcode = boletoBarcode;
        this.referer = referer;
        this.ip = ip;
        this.acquirerName = acquirerName;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.statusReason = statusReason;
        this.dateUpdated = dateUpdated;
        this.customer = customer;
        this.dateCreated = dateCreated;
        this.card = card;
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

    public Integer getRefundedAmount() {
        return refundedAmount;
    }

    public void setRefundedAmount(Integer refundedAmount) {
        this.refundedAmount = refundedAmount;
    }

    public Integer getAuthorizedAmount() {
        return authorizedAmount;
    }

    public void setAuthorizedAmount(Integer authorizedAmount) {
        this.authorizedAmount = authorizedAmount;
    }

    public Integer getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Integer paidAmount) {
        this.paidAmount = paidAmount;
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

    public String getBoletoUrl() {
        return boletoUrl;
    }

    public void setBoletoUrl(String boletoUrl) {
        this.boletoUrl = boletoUrl;
    }

    public String getBoletoBarcode() {
        return boletoBarcode;
    }

    public void setBoletoBarcode(String boletoBarcode) {
        this.boletoBarcode = boletoBarcode;
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

    public String getAcquirerName() {
        return acquirerName;
    }

    public void setAcquirerName(String acquirerName) {
        this.acquirerName = acquirerName;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Cartao getCard() {
        return card;
    }

    public void setCard(Cartao card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Transacao{" + "id=" + id + ", amount=" + amount + ", refundedAmount=" + refundedAmount + ", authorizedAmount=" + authorizedAmount + ", paidAmount=" + paidAmount + ", installments=" + installments + ", cost=" + cost + ", tid=" + tid + ", nsu=" + nsu + ", boletoUrl=" + boletoUrl + ", boletoBarcode=" + boletoBarcode + ", referer=" + referer + ", ip=" + ip + ", acquirerName=" + acquirerName + ", paymentMethod=" + paymentMethod + ", status=" + status + ", statusReason=" + statusReason + ", dateUpdated=" + dateUpdated + ", customer=" + customer + ", dateCreated=" + dateCreated + ", card=" + card + '}';
    }
}
