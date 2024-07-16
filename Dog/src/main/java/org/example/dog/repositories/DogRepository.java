package org.example.dog.repositories;

import org.example.dog.entity.Dog;
import org.example.dog.util.DataBaseConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DogRepository {
    private final SessionFactory sessionFactory;
    private Session session;

    public DogRepository() {
        sessionFactory = DataBaseConnection.getSessionFactory();
    }

    public List<Dog> getAllDogs() {
        try {
            session = sessionFactory.openSession();
            return session.createQuery("from Dog", Dog.class).list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public boolean saveDog(Dog dog) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(dog);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
            return false;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public Dog getDogById(int id) {
        try {
            session = sessionFactory.openSession();
            return session.get(Dog.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public boolean updateDog(Dog dog) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(dog);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
            return false;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public boolean deleteDog(Dog dog) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(dog);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
            return false;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

}
