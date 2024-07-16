package org.example.consultation.repository;

import org.example.consultation.entity.Patient;
import org.example.consultation.util.DataBaseConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class PatientRepository {
    private final SessionFactory sessionFactory;
    GeneralRepository generalRepository = new GeneralRepository();
    private Session session;

    public PatientRepository() {
        sessionFactory = DataBaseConnection.getSessionFactory();
    }

    public List<Patient> patientList() {
        try {
            session = sessionFactory.openSession();
            return session.createQuery("from Patient ", Patient.class).list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public Patient getPatientById(int id) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Patient patient = session.get(Patient.class, id);
            session.getTransaction().commit();
            return  patient;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public boolean addPatient(Patient patient) {
        return generalRepository.add(patient);
    }

    public boolean updatePatient(Patient patient) {
        return generalRepository.update(patient);
    }

    public boolean deletePatient(Patient patient) {
        return generalRepository.delete(patient);
    }

}
