package org.app.exo5.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.app.exo5.models.Car;
import org.app.exo5.repository.CarRepository;

import java.util.List;

@ApplicationScoped
public class CarService implements ICarService {

    @Inject
    private CarRepository carRepository;

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public void save(Car car) {
        carRepository.create(car);
    }

    @Override
    public Car update(Long id, Car car) {
        return carRepository.update(car);
    }

    @Override
    public void delete(Long id) {
        carRepository.delete(id);
    }
}