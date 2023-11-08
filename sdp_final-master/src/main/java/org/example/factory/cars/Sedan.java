package org.example.factory.cars;

public abstract class Sedan implements Car {
    public Sedan(String name, String country, int year, String color, int cost, Engine engine, Transmission transmission, Wheels wheels) {
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public double getCost() {
        return 0;
    }

    @Override
    public String getBrand() {
        return null;
    }

    @Override
    public String getModel() {
        return null;
    }

    @Override
    public int getHorsePower() {
        return 0;
    }

    @Override
    public String getCarId() {
        return null;
    }
}
