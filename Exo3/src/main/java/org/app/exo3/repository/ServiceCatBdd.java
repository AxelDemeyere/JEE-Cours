package org.app.exo3.repository;

import org.app.exo3.models.Cat;
import org.app.exo3.services.ICatService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class ServiceCatBdd implements ICatService {

    private CatRepository catRepository;
    private final SessionFactory _sessionFactory;
    private Session session;

    public ServiceCatBdd(SessionFactory _sessionFactory) {
        this._sessionFactory = _sessionFactory;

    }

    @Override
    public List<Cat> getAllCats() {
        List<Cat> cats = new ArrayList<>();
        session = _sessionFactory.openSession();
        catRepository = new CatRepository(session);
        try {
            cats = catRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cats;
    }

    @Override
    public Cat getCatById(Long id) {
        return null;
    }

    @Override
    public void addCat(Cat cat) {
        session = _sessionFactory.openSession();
        session.beginTransaction();
        catRepository = new CatRepository(session);
        try {
            catRepository.create(cat);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    @Override
    public Cat updateCat(Long id, Cat cat) {
        return null;
    }

    @Override
    public void deleteCat(Long id) {

    }
}
