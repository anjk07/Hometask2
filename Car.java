package prechec;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Car {
    private int id;
    private String make;
    private String model;
    private int yearOfManufacture;
    private String color;
    private double price;
    private String registrationNumber;

    public Car(int id, String make, String model, int yearOfManufacture, String color, double price, String registrationNumber) {
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
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "TATA", "Sedan", 2023, "Black", 25000, "DL0001"));
        cars.add(new Car(2, "TATA", "Sedan", 2023, "Black", 25000, "DL0001"));
        cars.add(new Car(3, "BMW", "SUV", 1990, "White", 23000, "DL0002"));
        cars.add(new Car(4, "Toyota", "Sedan", 2015, "Red", 20000, "DL0030"));
        cars.add(new Car(5, "TATA", "Altroz", 2021, "Orange", 15000, "DL1101"));
        cars.add(new Car(6, "BMW", "Harrier", 2017, "Blue", 89000, "DL0007"));

        String brandToFilter = "Tata";
        saveCarsByBrand(cars, brandToFilter, "TataCars.txt");

    }

    private static void saveCarsByBrand(List<Car> cars, String brandToFilter, String fileName) {
        List<Car> filteredCars = new ArrayList<>();

        // Iterate through the list of cars and filter by brand
        for (Car car : cars) {
            if (car.getMake().equalsIgnoreCase(brandToFilter)) {
                filteredCars.add(car);
            }
        }

        // Write the filtered cars to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Car car : filteredCars) {
                writer.write("Car ID: " + car.getId() + "\n");
                writer.write("Make: " + car.getMake() + "\n");
                writer.write("Model: " + car.getModel() + "\n");
                writer.write("Year of Manufacture: " + car.getYearOfManufacture() + "\n");
                writer.write("Color: " + car.getColor() + "\n");
                writer.write("Price: $" + car.getPrice() + "\n");
                writer.write("Registration Number: " + car.getRegistrationNumber() + "\n");
                writer.write("\n");
            }
            System.out.println("Cars of brand " + brandToFilter + " saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
