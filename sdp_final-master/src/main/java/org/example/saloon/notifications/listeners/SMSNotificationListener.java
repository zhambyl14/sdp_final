package org.example.saloon.notifications.listeners;

import org.example.factory.cars.Car;
import org.example.saloon.payment.PayStrategy;

public class SMSNotificationListener implements EventListener {
    private String phoneNumber;

    public SMSNotificationListener(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(String eventType, Car car) {
        if (eventType.equals("order")) {
            System.out.println("SMS to " + phoneNumber + ": car with this options below was ordered\n" + car.getDescription());
            System.out.println("________________________________________________ ");
            System.out.println(" ");
        }
    }

    @Override
    public void update(String eventType, PayStrategy pay) {
        if (eventType.equals("order")) {
            System.out.println("SMS to " + phoneNumber + ": user ordered a car with " + pay.getPaymentType());
        }
    }
}
