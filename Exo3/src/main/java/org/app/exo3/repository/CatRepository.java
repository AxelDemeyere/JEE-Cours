package org.app.exo3.repository;


import org.app.exo3.models.Cat;
import org.hibernate.Session;

import java.util.List;

public class CatRepository extends Repository<Cat> {

    public CatRepository(Session session) {
        super(session);
    }

    @Override
    public List<Cat> findAll() {
        return _session.createQuery("from Cat", Cat.class).getResultList();
    }
}
