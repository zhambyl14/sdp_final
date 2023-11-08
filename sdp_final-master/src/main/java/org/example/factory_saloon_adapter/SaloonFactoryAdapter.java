package org.example.factory_saloon_adapter;

import org.example.factory.CarsFactory;
import org.example.factory.cars.Car;
import org.example.saloon.notifications.EventManager;
import org.example.saloon.payment.PayByCard;
import org.example.saloon.payment.PayByCash;
import org.example.saloon.shop.Client;
import org.example.saloon.shop.ClientAccount;
import org.example.saloon.shop.Order;

public class SaloonFactoryAdapter {
    private ClientAccount clientAccount;
    private Order order;
    private CarsFactory factory;
    public EventManager events;

    // Constructor for initializing the adapter
    public SaloonFactoryAdapter(ClientAccount clientAccount, CarsFactory factory) {
        this.clientAccount = clientAccount;
        this.order = new Order(this.clientAccount.getClient());
        this.factory = factory;
        this.events = new EventManager("create", "order");
    }

    // Method to place an order for a car
    public void OrderCar(String subtype, String type, String brand, String model, int horsePower, double cost, String carId, String paymentType) {
        // Display the order details
        System.out.println(order.setOrder(type, brand, model));

        // Notify based on the payment type ("cash" or "card")
        if (paymentType.equals("cash")) {
            events.notify("order", new PayByCash(this.clientAccount.getClient()));
        } else {
            events.notify("order", new PayByCard(this.clientAccount.getClient()));
        }

        Car car = null;
        // Create the requested car based on subtype
        if (subtype.equals("default")) {
            car = factory.createCar(type);
        } else {
            car = factory.createCar(type, brand, model, horsePower, cost, carId);
        }
        // Notify listeners about the car creation
        events.notify("create", car);
    }

    // Method to upgrade a car by specifying its ID and a list of upgrades
    public void upgradeCar(String carId, String ...upgrades) {
        this.clientAccount.upgradeCar(carId, upgrades);
    }
}
