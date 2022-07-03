package repository;

import models.Doctor;

import java.util.Set;

public interface DoctorRepository {

    Set<Doctor> findAll();

    void save(Doctor doctor);

    void remove(Doctor doctor);
}