package org.example.consultation.repository;

import org.example.consultation.util.DataBaseConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GeneralRepository {

    private final SessionFactory sessionFactory;
    private Session session;

    public GeneralRepository() {
        sessionFactory = DataBaseConnection.getSessionFactory();
    }

    public boolean add(Object entity) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public boolean update(Object entity) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public boolean delete(Object entity) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

}
