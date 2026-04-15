package com.example.donation;

public class DonationApplication {
    public static void main(String[] args) {
        DonationService donationService = new DonationService();

        Donation donation1 = new Donation("Ragul", "ragul@example.com", 1000.0, "UPI");
        Donation donation2 = new Donation("Anu", "anu@example.com", 500.0, "CARD");

        DonationRecord record1 = donationService.processDonation(donation1);
        DonationRecord record2 = donationService.processDonation(donation2);

        System.out.println("Online Donation System Started");
        System.out.println(record1);
        System.out.println(record2);
        System.out.println("Total Donations Received: " + donationService.getTotalDonations());
    }
}
