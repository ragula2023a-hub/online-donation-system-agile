package com.example.donation;

public class Donation {
    private final String donorName;
    private final String email;
    private final double amount;
    private final String paymentMethod;

    public Donation(String donorName, String email, double amount, String paymentMethod) {
        this.donorName = donorName;
        this.email = email;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public String getDonorName() {
        return donorName;
    }

    public String getEmail() {
        return email;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
