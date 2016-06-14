package ua.rud.mobilecompany.account;

import ua.rud.mobilecompany.tariff.Tariff;

import java.util.Set;

public abstract class Account {
    private String clientName;
    private long balance;

    /*Getters and setters*/
    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public abstract Tariff getTariff();
}
