package org.example.saloon.shop;

public class Client {
    private String name;
    private String phoneNumber;
    private String email;
    private boolean receiveNotifications; // New attribute

    public Client(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.receiveNotifications = false; // Default is not to receive notifications
    }

    public String getDescription() {
        return "Name: " + this.getName() + "\nPhone number: " + this.getPhoneNumber() + "\nEmail: " + this.getEmail();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isReceiveNotifications() {
        return receiveNotifications;
    }

    public void setReceiveNotifications(boolean receiveNotifications) {
        this.receiveNotifications = receiveNotifications;
    }
}
