package org.example.consultation.service;

import org.example.consultation.entity.Doctor;
import org.example.consultation.entity.Patient;
import org.example.consultation.repository.PatientRepository;


import java.time.LocalDate;
import java.util.List;

public class PatientService {
    PatientRepository patientRepository = new PatientRepository();
    DoctorService doctorService = new DoctorService();

    public List<Patient> listPatients() {
        return patientRepository.patientList();
    }

    public boolean addPatient(String firstName, String lastName, String birthDate, String doctorId, String imgName) {
        LocalDate parsedBirthDate = LocalDate.parse(birthDate);
        int parsedDoctorId = Integer.parseInt(doctorId);

        Doctor doctor = doctorService.getDoctorById(parsedDoctorId);
        if (doctor == null) {
            return false;
        }

        Patient patient = new Patient(firstName, lastName, parsedBirthDate, doctor, imgName);
        return patientRepository.addPatient(patient);
    }

    public boolean deletePatient(String id) {
        int parsedId = Integer.parseInt(id);
        boolean isDeleted = false;
        Patient patient = patientRepository.getPatientById(parsedId);
        if (patient != null) {
            return patientRepository.deletePatient(patient);
        }
        return isDeleted;
    }

    public Patient getPatientById(int id) {
        return patientRepository.getPatientById(id);
    }

    public boolean updatePatient(String firstName, String lastName, String birthDate, String doctorId, String imgName) {
        LocalDate parsedBirthDate = LocalDate.parse(birthDate);

        int parsedDoctorId = Integer.parseInt(doctorId);

        Doctor doctor = doctorService.getDoctorById(parsedDoctorId);
        if (doctor == null) {
            return false;
        }

        Patient patient = new Patient(firstName, lastName, parsedBirthDate, doctor, imgName );
        return patientRepository.updatePatient(patient);
    }
}
