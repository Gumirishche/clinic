package repository.impl;


import models.Doctor;
import repository.DoctorRepository;

import java.util.HashSet;
import java.util.Set;

public class DoctorRepositoryImpl implements DoctorRepository {

    private static final Set<Doctor> DOCTORS = new HashSet<>(); // Используем множество, а не список или массив, так как договорились,


    private static final DoctorRepositoryImpl SINGLETON = new DoctorRepositoryImpl();   // Используем паттерн singleton,


    private DoctorRepositoryImpl() {
    }

    public static DoctorRepositoryImpl getSingleton() {
        return SINGLETON;
    }

    @Override
    public Set<Doctor> findAll() {
        return DOCTORS;
    }

    @Override
    public void save(Doctor doctor) {
        DOCTORS.add(doctor);
    }

    @Override
    public void remove(Doctor doctor) {
        DOCTORS.remove(doctor);
    }
}