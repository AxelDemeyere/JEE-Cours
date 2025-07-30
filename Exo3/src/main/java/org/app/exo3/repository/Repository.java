package org.app.exo3.repository;

import org.hibernate.Session;

import java.util.List;

public class Repository<T> {
     protected Session _session;

     public Repository(Session session) {
         this._session = session;
     }

    public void create(T entity) {
             _session.persist(entity);
    }

    public void update(T entity) {
             _session.merge(entity);
    }

    public void delete(T entity) {
             _session.remove(entity);
    }

    public List<T> findAll() {
        return null;
    }


}
