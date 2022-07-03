package repository;

import people.Doctor;
import people.Patient;

import java.util.Set;

public interface PatientRepository {

    Set<Patient> findAll();

    void save(Patient patient);

    void remove(Patient patient);

    void update(Patient patient);
}