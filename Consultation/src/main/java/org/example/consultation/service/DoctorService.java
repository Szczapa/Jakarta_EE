package org.example.consultation.service;

import org.example.consultation.entity.Doctor;
import org.example.consultation.repository.DoctorRepository;

import java.util.ArrayList;
import java.util.List;

public class DoctorService {
    private final DoctorRepository doctorRepository = new DoctorRepository();
    public List<Doctor> getDoctorList() {
        return  doctorRepository.getDoctorList();
    }

    public Doctor getDoctorById(int doctorId) {
        return doctorRepository.getDoctorById(doctorId);
    }

    public void addDoctor(Doctor doctor) {
        doctorRepository.addDoctor(doctor);
    }
}
