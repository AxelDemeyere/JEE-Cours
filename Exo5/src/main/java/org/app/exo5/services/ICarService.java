package org.app.exo5.services;

import org.app.exo5.models.Car;

import java.util.List;

public interface ICarService {
    List<Car> findAll();
    Car findById(Long id);
    void save(Car car);
    Car update(Long id, Car car);
    void delete(Long id);
}
