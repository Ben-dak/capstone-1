package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    LocalDate date;
    LocalTime time;
    String description;
    String vendor;
    double amount;

    public Transaction(LocalDate date, LocalTime tm, String desc, String vend, double amt) {
        this.vendor = vend;
        this.date = date;
        this.time = tm;
        this.description = desc;
        this.amount = amt;
    }
    public Transaction(String description, String vendor, double amount) {
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
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

    public String toString() {
        return String.format("%s|%s|%s|%s|%.2f", date, time, description, vendor, amount); //pulls info from public Transaction above and converts to text
    }
}
