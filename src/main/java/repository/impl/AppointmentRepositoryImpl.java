package repository.impl;

import models.Appointment;
import repository.AppointmentRepository;

import java.util.HashSet;
import java.util.Set;

public class AppointmentRepositoryImpl implements AppointmentRepository {
    private static final Set<Appointment> APPOINTMENTS = new HashSet<>(); // Используем множество, а не список или массив, так как договорились,

    private static final AppointmentRepositoryImpl SINGLETON = new AppointmentRepositoryImpl();   // Используем паттерн singleton,


    private AppointmentRepositoryImpl() {
    }

    public static AppointmentRepositoryImpl getSingleton() {
        return SINGLETON;
    }

    @Override
    public Set<Appointment> findAll() {
        return APPOINTMENTS;
    }

    @Override
    public void save(Appointment appointment) {
        APPOINTMENTS.add(appointment);
    }

    @Override
    public void remove(Appointment appointment) {
        APPOINTMENTS.remove(appointment);
    }
}
