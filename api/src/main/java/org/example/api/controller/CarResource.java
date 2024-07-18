package org.example.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.api.entity.Car;
import org.example.api.service.CarService;

import java.time.LocalDate;
import java.util.List;

@Path("/cars")
public class CarResource {

    private final CarService carService;

    @Inject
    public CarResource(CarService carService) {
        this.carService = carService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getCars() {
        return carService.carList();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Car createCar(Car car) {
        if (car == null) {
            System.out.println("Received null Car object");
            return null;
        }
        System.out.println("Received Car: " + car.getBrand());
        return carService.saveCar(car);
    }

    @PUT
    @Path("/{carId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car updateCar(@PathParam("carId") int carId, Car car) {
        return carService.updateCar(carId, car.getBrand(), car.getColor(), String.valueOf(car.getProductionDate()));
    }

    @DELETE
    @Path("/{carId}")
    public int deleteCar(@PathParam("carId") int carId) {
        Car car = carService.deleteCar(carId);
        return car != null ? car.getCarId() : -1;
    }

    @GET
    @Path("/{carId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car getCarById(@PathParam("carId") int carId) {
        return carService.getById(carId);
    }
}
