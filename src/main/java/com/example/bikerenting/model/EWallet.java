package com.example.bikerenting.model;

public class EWallet {
    private String owner;
    private String phoneNumber;
    private int walletPassword;

    public EWallet(String owner, String phoneNumber, int walletPassword) {
        this.owner = owner;
        this.phoneNumber = phoneNumber;
        this.walletPassword = walletPassword;
    }
}
