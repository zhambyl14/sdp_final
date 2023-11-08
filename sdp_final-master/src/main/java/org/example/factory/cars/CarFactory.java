package org.example.factory.cars;

import org.example.factory.CarsFactory;
import org.example.factory.CarsFactory;

public class CarFactory {

    private CarsFactory carsFactory;

    // Constructor to initialize the CarFactory with a CarsFactory instance
    public CarFactory(CarsFactory carsFactory) {
        this.carsFactory = carsFactory;
    }

    // Create a car based on the provided parameters
    public Car createCar(String name, String country, int year, String color, int cost, String type) {
        // Create instances of various car components
        Engine engine = new Engine();
        Transmission transmission = new Transmission();
        Wheels wheels = new Wheels();

        Car car = null;

        // Check the car type and create the corresponding car object
        if (type.equals("Coupe")) {
            car = new Coupe(name, country, year, color, cost, engine, transmission, wheels) {
                // Provide empty override methods for car details
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

                @Override
                public boolean getDescriptionWithUpgrades() {
                    return false;
                }
            };
        } else if (type.equals("Sedan")) {
            car = new Sedan(name, country, year, color, cost, engine, transmission, wheels) {
                // Provide an empty override method for car description with upgrades
                @Override
                public boolean getDescriptionWithUpgrades() {
                    return false;
                }
            };
        }

        // If a car is created, add it to the CarsFactory
        if (car != null) {
            carsFactory.addCar(car);
        }

        return car;
    }
}
