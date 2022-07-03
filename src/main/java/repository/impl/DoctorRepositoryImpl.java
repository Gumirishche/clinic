package repository.impl;


import people.Doctor;
import repository.DoctorRepository;

import java.util.HashSet;
import java.util.Set;

public class DoctorRepositoryImpl implements DoctorRepository {

    private static final Set<Doctor> NOTES = new HashSet<>(); // Используем множество, а не список или массив, так как договорились,
    // что хотим хранить только уникальные заметки. Уникальность заметок
    // определяется с помощью методов Note#equals и Note#hashcode.

    private static final DoctorRepositoryImpl SINGLETON = new DoctorRepositoryImpl();   // Используем паттерн singleton,
    // то есть когда мы создаем внутри класса ровно 1 объект
    // на все приложение и потом выдаем его другим классам, чтобы они его использовали.
    // При этом прячем конструктор, делая его приватным.

    private DoctorRepositoryImpl() {}

    public static DoctorRepositoryImpl getSingleton() {
        return SINGLETON;
    }

    @Override
    public Set<Doctor> findAll() {
        return NOTES;
    }

    @Override
    public void save(Doctor doctor) {
        NOTES.add(doctor);
    }

    @Override
    public void remove(Doctor doctor) {
        NOTES.remove(doctor);
    }
}