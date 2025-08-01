package org.app.exo5.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.app.exo5.models.Car;
import org.app.exo5.services.CarService;

import java.util.List;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/car")
@ApplicationScoped
public class CarController {

    private CarService carService;

    @Inject
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GET
    @Path("/findAll")
    public List<Car> getAllCars() {
        return carService.findAll();
    }

    @GET
    @Path("/find/{id}")
    public Car getCarById(@PathParam("id") Long id) {
        return carService.findById(id);
    }

    @POST
    @Path("/add")
    public Car addCar(Car car) {
        carService.save(car);
        return car;
    }

    @PUT
    @Path("/update/{id}")
    public Car updateCar(@PathParam("id") Long id, Car car) {
        return carService.update(id, car);
    }

    @DELETE
    @Path("/delete/{id}")
    public void deleteCar(@PathParam("id") Long id) {
        carService.delete(id);
    }
}
