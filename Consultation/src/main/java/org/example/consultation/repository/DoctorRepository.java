package org.example.consultation.repository;

import org.example.consultation.entity.Doctor;
import org.example.consultation.util.DataBaseConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class DoctorRepository {

    private final SessionFactory sessionFactory;
    private Session session;
    GeneralRepository generalRepository = new GeneralRepository();

    public DoctorRepository() {
        sessionFactory = DataBaseConnection.getSessionFactory();
    }

    public List<Doctor> getDoctorList() {
        try {
            session = sessionFactory.openSession();
            return session.createQuery("from Doctor", Doctor.class).list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public Doctor getDoctorById(int doctorId) {
        try {
            session = sessionFactory.openSession();
            return session.get(Doctor.class, doctorId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public boolean addDoctor(Doctor doctor) {
        return generalRepository.add(doctor);
    }
}
