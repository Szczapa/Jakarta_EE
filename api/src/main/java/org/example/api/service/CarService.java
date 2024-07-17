package org.example.api.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.api.entity.Car;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CarService {

    // inject Car entity and List<Car> cars

    @Inject
    private Car car;
    @Inject
    private List<Car> cars ;

    public Car saveCar(int carId, String brand, String color, String productionDate) {
        Car car = new Car(carId, brand, color, Integer.parseInt(productionDate));
        cars.add(car);
        return car;
    }

    public List<Car> carList() {
        List<Car> cars = car.getCars();

        if (cars == null) {
            cars = new ArrayList<>();
            car.setCars(cars);
        }
        return cars ;

    }

    public Car getById(int carId) {
        return cars.stream()
                .filter(car -> car.getCarId() == carId)
                .findFirst()
                .orElse(null);
    }

    public Car deleteCar(int carId) {
        Car car = getById(carId);
        cars.remove(car);
        return car;
    }

    public Car updateCar(int carId, String brand, String color, String productionDate) {
        Car car = getById(carId);
        car.setBrand(brand);
        car.setColor(color);
        car.setProductionDate(Integer.parseInt(productionDate));
        return car;
    }
}
