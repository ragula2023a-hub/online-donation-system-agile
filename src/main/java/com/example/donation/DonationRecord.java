package com.example.donation;

public class DonationRecord {
    private final String transactionId;
    private final Donation donation;
    private final String status;

    public DonationRecord(String transactionId, Donation donation, String status) {
        this.transactionId = transactionId;
        this.donation = donation;
        this.status = status;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Donation getDonation() {
        return donation;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "DonationRecord{" +
                "transactionId='" + transactionId + '\'' +
                ", donor='" + donation.getDonorName() + '\'' +
                ", amount=" + donation.getAmount() +
                ", paymentMethod='" + donation.getPaymentMethod() + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
