package org.app.exo4.service;

import org.app.exo4.models.Dog;
import org.app.exo4.repository.DogRepository;
import org.app.exo4.utils.HibernateSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DogService implements IDogService {

    private static DogService instance;

    public DogService() {}

    public static DogService getInstance() {
        if (instance == null) {
            instance = new DogService();
        }
        return instance;
    }

    @Override
    public List<Dog> findAll() {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            DogRepository dogRepository = new DogRepository(session);
            return dogRepository.findAll();
        }
    }

    @Override
    public Dog findById(Long id) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            DogRepository dogRepository = new DogRepository(session);
            return dogRepository.findById(id);
        }
    }

    @Override
    public void save(Dog dog) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            DogRepository dogRepository = new DogRepository(session);
            transaction = session.beginTransaction();
            dogRepository.create(dog);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Dog update(Long id, Dog dog) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            DogRepository dogRepository = new DogRepository(session);
            transaction = session.beginTransaction();

            Dog dog = dogRepository.findById(id);
            if (dog != null) {
                dogRepository.delete(dog);
                transaction.commit();
            } else {
                transaction.rollback();
                System.out.println("Chien avec ID " + id + " non trouvé");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
