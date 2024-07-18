package org.example.api.entity;

import java.util.List;

public class Car {
    private int carId;
    private String brand;
    private String color;
    private int productionDate;
    private List<Car> cars;

    public Car() {}

    public Car(int carId, String brand, String color, int productionDate) {
        this.carId = carId;
        this.brand = brand;
        this.color = color;
        this.productionDate = productionDate;
    }

    // Getters and setters

    public int getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(int productionDate) {
        this.productionDate = productionDate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }
}
