package org.example.saloon.payment;

import org.example.saloon.shop.Client;

public class PayByCash implements PayStrategy {
    private Client client;

    // Constructor to initialize PayByCash with a client
    public PayByCash(Client client) {
        this.client = client;
    }

    @Override
    public String pay(int paymentAmount, int cost) {
        // Check if the payment amount is sufficient to cover the cost
        if (paymentAmount >= cost) {
            // Return a payment success message
            return "Client with " + client.getDescription() + " \nPaid " + paymentAmount + "$ by cash";
        }
        // Return a payment failure message if the payment amount is insufficient
        return "Client with " + client.getDescription() + " don't have enough cash to pay";
    }

    @Override
    public String getPaymentType() {
        // Return the payment type as "cash"
        return "cash";
    }
}
