package org.app.exo3.services;

import org.app.exo3.models.Cat;

import java.util.List;

public interface ICatService {
    List<Cat> getAllCats();
    Cat getCatById(Long id);
    void addCat(Cat cat);
    Cat updateCat(Long id, Cat cat);
    void deleteCat(Long id);

}
