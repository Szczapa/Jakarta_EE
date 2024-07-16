package org.example.consultation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String imgName;

    // Médecin traitant
    // un médecin peut avoir plusieurs patients mais un patient ne peut avoir qu'un seul médecin
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Patient(String firstName, String lastName, LocalDate birthDate, Doctor doctor, String imgName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.doctor = doctor;
        this.imgName = imgName;
    }

}
