package org.example.factory;

import org.example.factory.cars.BasicCar;
import org.example.factory.cars.Car;
import org.example.factory.cars.concrete_cars.CoupeCarDecorator;
import org.example.factory.cars.concrete_cars.SedanCarDecorator;

public class CarsFactory {
    private static CarsFactory carsFactory; // Singleton instance of the CarsFactory
    private String factoryName; // Name of the factory

    public CarsFactory(String factoryName) {
        this.factoryName = factoryName;
    }

    public static CarsFactory getInstance(String factoryName) {
        // Singleton pattern to ensure only one instance of the factory exists
        if (carsFactory == null) {
            carsFactory = new CarsFactory(factoryName);
        }
        return carsFactory;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public Car createCar(String type) { // Create a car with no specific options
        switch (type) {
            case "basic" -> {
                return new BasicCar(); // Create a basic car
            }
            case "sedan" -> {
                return new SedanCarDecorator(new BasicCar()) { // Decorate a basic car as a sedan
                    @Override
                    public boolean getDescriptionWithUpgrades() {
                        return false;
                    }
                };
            }
            case "coupe" -> {
                return (Car) new CoupeCarDecorator(new BasicCar()) { // Decorate a basic car as a coupe
                    @Override
                    public boolean getDescriptionWithUpgrades() {
                        return false;
                    }
                };
            }
            default -> {
                return null;
            }
        }
    }

    public Car createCar(String type, String brand, String model, int horsePower, double cost, String carId) {
        // Create a car with specific options
        switch (type) {
            case "basic" -> {
                return new BasicCar(brand, model, horsePower, cost, carId); // Create a basic car with specific options
            }
            case "sedan" -> {
                return new SedanCarDecorator(new BasicCar(brand, model, horsePower, cost, carId)) {
                    // Decorate a basic car as a sedan with specific options
                    @Override
                    public boolean getDescriptionWithUpgrades() {
                        return false;
                    }
                };
            }
            case "coupe" -> {
                return new CoupeCarDecorator(new BasicCar(brand, model, horsePower, cost, carId)) {
                    // Decorate a basic car as a coupe with specific options
                    @Override
                    public boolean getDescriptionWithUpgrades() {
                        return false;
                    }
                };
            }
            default -> {
                return null;
            }
        }
    }

    public void addCar(Car car) {
        // Add a car to the factory's inventory
    }
}
