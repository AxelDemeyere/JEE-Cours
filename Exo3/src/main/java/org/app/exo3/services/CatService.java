package org.app.exo3.services;

import org.app.exo3.models.Cat;
import org.app.exo3.utils.HibernateSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CatService implements ICatService {

    private static CatService instance;

    private CatService() {
        // Constructeur privé pour empêcher l'instanciation directe
    }

    public static CatService getInstance() {
        if (instance == null) {
            instance = new CatService();
        }
        return instance;
    }

    @Override
    public List<Cat> getAllCats() {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            return session.createQuery("FROM Cat", Cat.class).list();
        }
    }

    @Override
    public Cat getCatById(Long id) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            return session.get(Cat.class, id);
        }
    }

    @Override
    public void addCat(Cat cat) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(cat);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Cat updateCat(Long id, Cat cat) {
        return null;
    }

    @Override
    public void deleteCat(Long id) {}
}