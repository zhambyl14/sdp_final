package org.example.saloon.payment;

import org.example.saloon.shop.Client;

public class PayByCard implements PayStrategy {
    private Client client;

    // Constructor to initialize PayByCard with a client
    public PayByCard(Client client) {
        this.client = client;
    }

    @Override
    public String pay(int paymentAmount, int cost) {
        // Check if the payment amount is sufficient to cover the cost
        if (paymentAmount >= cost) {
            // Return a payment success message with the payment amount and type
            return "Client with " + client.getDescription() + " paid " + paymentAmount + "$ by card.";
        }
        // Return a payment failure message if the payment amount is insufficient
        return "Client with " + client.getDescription() + " doesn't have enough money on the card to pay.";
    }

    @Override
    public String getPaymentType() {
        // Return the payment type as "card"
        return "card";
    }
}
