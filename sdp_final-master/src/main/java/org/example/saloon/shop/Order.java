package org.example.saloon.shop;

public class Order {
    private Client client;

    public Order(Client client) {
        this.client = client;
    }
    public String setOrder(String carType, String carBrand, String carModel) {
        return "Client with: " + this.client.getDescription() + " ordered a car with type: " + carType + ", brand: " + carBrand + ", model: " + carModel;
    }
}
