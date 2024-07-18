package org.example.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.api.entity.Car;

import java.util.List;

@ApplicationScoped
public class CarService {

    @Inject
    private List<Car> cars;

public Car saveCar(Car car) {
    if (car == null) {
        return null;
    }
    int carId = cars.size() + 1;
    car.setCarId(carId);
    cars.add(car);
    return car;
}

    public List<Car> carList() {
        return cars;
    }

    public Car getById(int carId) {
        return cars.stream()
                .filter(car -> car.getCarId() == carId)
                .findFirst()
                .orElse(null);
    }

    public Car deleteCar(int carId) {
        Car car = getById(carId);
        if (car != null) {
            cars.remove(car);
        }
        return car;
    }

    public Car updateCar(int carId, String brand, String color, String productionDate) {
        Car car = getById(carId);
        if (car != null) {
            car.setBrand(brand);
            car.setColor(color);
            car.setProductionDate(Integer.parseInt(productionDate));
        }
        return car;
    }
}
