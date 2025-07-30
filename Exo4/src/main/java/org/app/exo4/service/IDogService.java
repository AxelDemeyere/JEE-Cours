package org.app.exo4.service;

import org.app.exo4.models.Dog;

import java.util.List;

public interface IDogService {
    List<Dog> findAll();
    Dog findById(Long id);
    void save(Dog dog);
    Dog update(Long id, Dog dog);
    void delete(Long id);
}
