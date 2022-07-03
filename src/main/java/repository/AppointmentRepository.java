package repository;

import models.Appointment;

import java.util.Set;

public interface AppointmentRepository {
    Set<Appointment> findAll();

    void save(Appointment appointment);

    void remove(Appointment appointment);
}
