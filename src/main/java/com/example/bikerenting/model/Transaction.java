package com.example.bikerenting.model;

public class Transaction {
    private CreditCard creditCard;
    private EWallet eWallet;
    private int amount;
    private String createdAt;
    private String transactionContent;
    private String transactionId;
    private Boolean method;

    public Transaction(){

    }
    public Transaction(EWallet eWallet, int amount, String createdAt, String transactionContent, String transactionId) {
        this.eWallet = eWallet;
        this.amount = amount;
        this.createdAt = createdAt;
        this.transactionContent = transactionContent;
        this.transactionId = transactionId;
    }
    public Transaction(CreditCard creditCard, int amount, String createdAt, String transactionContent, String transactionId) {
        this.creditCard = creditCard;
        this.amount = amount;
        this.createdAt = createdAt;
        this.transactionContent = transactionContent;
        this.transactionId = transactionId;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public EWallet geteWallet() {
        return eWallet;
    }

    public void seteWallet(EWallet eWallet) {
        this.eWallet = eWallet;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getTransactionContent() {
        return transactionContent;
    }

    public void setTransactionContent(String transactionContent) {
        this.transactionContent = transactionContent;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Boolean getMethod() {
        return method;
    }

    public void setMethod(Boolean method) {
        this.method = method;
    }
}
