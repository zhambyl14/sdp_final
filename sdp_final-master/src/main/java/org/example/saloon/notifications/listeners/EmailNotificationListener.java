package org.example.saloon.notifications.listeners;

import org.example.factory.cars.Car;
import org.example.saloon.payment.PayStrategy;

public class EmailNotificationListener implements EventListener {
    private String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, Car car) {
        if (eventType.equals("order")) {
            System.out.println("Email to " + email + ": car with this options below was ordered\n" + car.getDescription());
            System.out.println("________________________________________________ ");
            System.out.println(" ");
        }
    }

    @Override
    public void update(String eventType, PayStrategy pay) {
        if (eventType.equals("order")) {
            System.out.println("Email to " + email + ": user ordered a car with " + pay.getPaymentType());
        }
    }
}
