package prechec;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Carb {
    private int id;
    private String make;
    private String model;
    private int yearOfManufacture;
    private String color;
    private double price;
    private String registrationNumber;

    public Carb(int id, String make, String model, int yearOfManufacture, String color, double price, String registrationNumber) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public int getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public static void main(String[] args) {
        List<Carb> cars = new ArrayList<>();
        cars.add(new Carb(1, "TATA", "Sedan", 2023, "Black", 25000, "DL0001"));
        cars.add(new Carb(2, "TATA", "Sedan", 2023, "Black", 25000, "DL0001"));
        cars.add(new Carb(3, "BMW", "SUV", 1990, "White", 23000, "DL0002"));
        cars.add(new Carb(4, "Toyota", "Sedan", 2015, "Red", 20000, "DL0030"));
        cars.add(new Carb(5, "TATA", "Altroz", 2021, "Orange", 15000, "DL1101"));
        cars.add(new Carb(6, "BMW", "Harrier", 2017, "Blue", 89000, "DL0007"));

        saveCarsByModelAndYears(cars, "Sedan", 5, "SedanCars.txt");
    }

    private static void saveCarsByModelAndYears(List<Carb> cars, String modelToFilter, int years, String fileName) {
        List<Carb> filteredCars = new ArrayList<>();

        // Get the current year
        int currentYear = java.time.Year.now().getValue();

        // Iterate through the list of cars and filter by model and years
        for (Carb car : cars) {
            if (car.getModel().equalsIgnoreCase(modelToFilter) && (currentYear - car.getYearOfManufacture() > years)) {
                filteredCars.add(car);
            }
        }

        // Write the filtered cars to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Carb car : filteredCars) {
                writer.write("Car ID: " + car.getId() + "\n");
                writer.write("Make: " + car.getMake() + "\n");
                writer.write("Model: " + car.getModel() + "\n");
                writer.write("Year of Manufacture: " + car.getYearOfManufacture() + "\n");
                writer.write("Color: " + car.getColor() + "\n");
                writer.write("Price: $" + car.getPrice() + "\n");
                writer.write("Registration Number: " + car.getRegistrationNumber() + "\n");
                writer.write("\n");
            }
            System.out.println("Cars of model " + modelToFilter + " with more than " + years + " years saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
