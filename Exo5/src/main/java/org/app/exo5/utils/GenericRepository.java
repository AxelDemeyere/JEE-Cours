package org.app.exo5.utils;

import org.hibernate.Session;
import java.util.List;

public class GenericRepository<T> {
    protected Session _session;
    private final Class<T> entityClass;

    public GenericRepository(Session session, Class<T> entityClass) {
        this._session = session;
        this.entityClass = entityClass;
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
        String hql = "FROM " + entityClass.getSimpleName();
        return _session.createQuery(hql, entityClass).getResultList();
    }

    public T findById(Long id) {
        return _session.find(entityClass, id);
    }
}