package org.app.exo4.repository;

import org.app.exo4.models.Dog;
import org.app.exo4.utils.GenericRepository;
import org.hibernate.Session;

import java.util.List;

public class DogRepository extends GenericRepository<Dog> {

    public DogRepository(Session session) {
        super(session, Dog.class);
    }

    @Override
    public List<Dog> findAll() {
        return _session.createQuery("from Dog", Dog.class).getResultList();
    }

    @Override
    public Dog findById(Long id) {
        return _session.find(Dog.class, id);
    }
}
