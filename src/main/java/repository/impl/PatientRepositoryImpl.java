package repository.impl;

import models.Patient;
import repository.PatientRepository;

import java.util.HashSet;
import java.util.Set;

public class PatientRepositoryImpl implements PatientRepository {
    private static final Set<Patient> PATIENTS = new HashSet<>(); // Используем множество, а не список или массив, так как договорились,


    private static final PatientRepositoryImpl SINGLETON = new PatientRepositoryImpl();   // Используем паттерн singleton,


    private PatientRepositoryImpl() {
    }

    public static PatientRepositoryImpl getSingleton() {
        return SINGLETON;
    }

    @Override
    public Set<Patient> findAll() {
        return PATIENTS;
    }

    @Override
    public void save(Patient patient) {
        PATIENTS.add(patient);
    }

    @Override
    public void remove(Patient patient) {
        PATIENTS.remove(patient);
    }
}
