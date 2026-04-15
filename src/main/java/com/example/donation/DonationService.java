package com.example.donation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DonationService {
    private static final List<String> ALLOWED_PAYMENT_METHODS = List.of("UPI", "CARD", "NET_BANKING", "CASH");
    private final List<DonationRecord> donationRecords = new ArrayList<>();

    public DonationRecord processDonation(Donation donation) {
        validateDonation(donation);
        String transactionId = "TXN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        DonationRecord record = new DonationRecord(transactionId, donation, "SUCCESS");
        donationRecords.add(record);
        return record;
    }

    public void validateDonation(Donation donation) {
        if (donation == null) {
            throw new IllegalArgumentException("Donation cannot be null");
        }
        if (donation.getDonorName() == null || donation.getDonorName().trim().isEmpty()) {
            throw new IllegalArgumentException("Donor name is required");
        }
        if (donation.getEmail() == null || !donation.getEmail().contains("@")) {
            throw new IllegalArgumentException("Valid email is required");
        }
        if (donation.getAmount() <= 0) {
            throw new IllegalArgumentException("Donation amount must be greater than zero");
        }
        if (donation.getPaymentMethod() == null || !ALLOWED_PAYMENT_METHODS.contains(donation.getPaymentMethod().toUpperCase())) {
            throw new IllegalArgumentException("Unsupported payment method");
        }
    }

    public List<DonationRecord> getDonationRecords() {
        return new ArrayList<>(donationRecords);
    }

    public double getTotalDonations() {
        return donationRecords.stream()
                .mapToDouble(record -> record.getDonation().getAmount())
                .sum();
    }
}
