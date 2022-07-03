package repository;

import models.Patient;

import java.util.Set;

public interface PatientRepository {

    Set<Patient> findAll();

    void save(Patient patient);

    void remove(Patient patient);
}