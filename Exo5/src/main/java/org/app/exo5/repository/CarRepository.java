package org.app.exo5.repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.app.exo5.models.Car;
import org.app.exo5.utils.GenericRepository;
import org.app.exo5.utils.HibernateSession;
import org.hibernate.Session;

import java.util.List;

@ApplicationScoped
public class CarRepository {

    public List<Car> findAll() {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            GenericRepository<Car> repo = new GenericRepository<>(session, Car.class);
            return repo.findAll();
        }
    }

    public Car findById(Long id) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            GenericRepository<Car> repo = new GenericRepository<>(session, Car.class);
            return repo.findById(id);
        }
    }

    public void create(Car car) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            session.beginTransaction();
            GenericRepository<Car> repo = new GenericRepository<>(session, Car.class);
            repo.create(car);
            session.getTransaction().commit();
        }
    }

    public Car update(Car car) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            session.beginTransaction();
            GenericRepository<Car> repo = new GenericRepository<>(session, Car.class);
            repo.update(car);
            session.getTransaction().commit();
            return car;
        }
    }

    public void delete(Long id) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            session.beginTransaction();
            GenericRepository<Car> repo = new GenericRepository<>(session, Car.class);
            Car car = repo.findById(id);
            if (car != null) {
                repo.delete(car);
            }
            session.getTransaction().commit();
        }
    }
}