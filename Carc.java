package prechec;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Carc {
    private int id;
    private String make;
    private String model;
    private int yearOfManufacture;
    private String color;
    private double price;
    private String registrationNumber;

    public Carc(int id, String make, String model, int yearOfManufacture, String color, double price, String registrationNumber) {
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
        List<Carc> cars = new ArrayList<>();
        cars.add(new Carc(1, "TATA", "Sedan", 2023, "Black", 250000, "DL0001"));
        cars.add(new Carc(2, "TATA", "Sedan", 2023, "Black", 250000, "DL0001"));
        cars.add(new Carc(3, "BMW", "SUV", 1990, "White", 23000, "DL0002"));
        cars.add(new Carc(4, "Toyota", "Sedan", 2015, "Red", 200000, "DL0030"));
        cars.add(new Carc(5, "TATA", "Altroz", 2021, "Orange", 15000, "DL1101"));
        cars.add(new Carc(6, "BMW", "Harrier", 2017, "Blue", 89000, "DL0007"));
        cars.add(new Carc(7, "TATA", "SUV", 2020, "Olive", 50000, "DL0007"));
        cars.add(new Carc(8, "Toyota", "Harrier", 2003, "Grey", 89000, "DL0007"));
        cars.add(new Carc(9, "BMW", "Sedan", 2020, "Orange", 200001, "DL0007"));
        cars.add(new Carc(10, "Toyota", "Sedan", 2001, "Black", 89000, "DL0007"));

        

        int yearToFilter = 2020;
        double priceToFilter = 20000;

        saveCarsByYearAndPrice(cars, yearToFilter, priceToFilter, "FilteredCars.txt");
    }

    private static void saveCarsByYearAndPrice(List<Carc> cars, int year, double price, String fileName) {
        List<Carc> filteredCars = new ArrayList<>();

        for (Carc car : cars) {
            if (car.getYearOfManufacture() == year && car.getPrice() > price) {
                filteredCars.add(car);
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Carc car : filteredCars) {
                writer.write("Car ID: " + car.getId() + "\n");
                writer.write("Make: " + car.getMake() + "\n");
                writer.write("Model: " + car.getModel() + "\n");
                writer.write("Year of Manufacture: " + car.getYearOfManufacture() + "\n");
                writer.write("Color: " + car.getColor() + "\n");
                writer.write("Price: $" + car.getPrice() + "\n");
                writer.write("Registration Number: " + car.getRegistrationNumber() + "\n");
                writer.write("\n");
            }
            System.out.println("Cars of year " + year + " with price higher than $" + price + " saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
