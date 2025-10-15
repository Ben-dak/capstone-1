package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    LocalDate date;
    LocalTime time;
    String description;
    String vendor;
    double amount;

    public Transaction(LocalDate da, String v, LocalTime t, String de, double a) {
        this.vendor = v;
        this.date = da;
        this.time = t;
        this.description = de;
        this.amount = a;

    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return this.vendor;
    }

    public void setVendor(String v) {
        this.vendor = v;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
