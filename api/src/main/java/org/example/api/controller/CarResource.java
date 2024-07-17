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
    @Produces(MediaType.APPLICATION_JSON)
    public Car createCar() {
        return carService.saveCar(1,"BMW", "Black", String.valueOf(LocalDate.now().getYear()));
    }

    @POST
    @Path("/{carId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car updateCar(@PathParam("carId") int carId, Car car) {
        return carService.updateCar(carId, car.getBrand(), car.getColor(), String.valueOf(car.getProductionDate()));
    }

    @DELETE
    @Path("/{carId}")
    public int deleteCar(@PathParam("carId") int carId) {
        return carService.deleteCar(carId).getCarId();
    }
}
