package com.example.donation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DonationServiceTest {

    private final DonationService donationService = new DonationService();

    @Test
    void shouldProcessValidDonationSuccessfully() {
        Donation donation = new Donation("Ragul", "ragul@example.com", 1000.0, "UPI");

        DonationRecord record = donationService.processDonation(donation);

        assertNotNull(record.getTransactionId());
        assertEquals("SUCCESS", record.getStatus());
        assertEquals(1000.0, record.getDonation().getAmount());
    }

    @Test
    void shouldThrowExceptionForInvalidAmount() {
        Donation donation = new Donation("Ragul", "ragul@example.com", 0.0, "UPI");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> donationService.processDonation(donation));

        assertEquals("Donation amount must be greater than zero", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForInvalidEmail() {
        Donation donation = new Donation("Ragul", "ragulexample.com", 1000.0, "CARD");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> donationService.processDonation(donation));

        assertEquals("Valid email is required", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForUnsupportedPaymentMethod() {
        Donation donation = new Donation("Ragul", "ragul@example.com", 1000.0, "CHEQUE");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> donationService.processDonation(donation));

        assertEquals("Unsupported payment method", exception.getMessage());
    }

    @Test
    void shouldCalculateTotalDonationsCorrectly() {
        donationService.processDonation(new Donation("Ragul", "ragul@example.com", 1000.0, "UPI"));
        donationService.processDonation(new Donation("Anu", "anu@example.com", 500.0, "CARD"));

        double total = donationService.getTotalDonations();

        assertEquals(1500.0, total);
        assertTrue(donationService.getDonationRecords().size() == 2);
    }
}
