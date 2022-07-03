package repository.impl;

import people.Patient;
import repository.PatientRepository;

import java.util.HashSet;
import java.util.Set;

public class PatientRepositoryImpl implements PatientRepository {
    private static final Set<Patient> NOTES = new HashSet<>(); // Используем множество, а не список или массив, так как договорились,
    // что хотим хранить только уникальные заметки. Уникальность заметок
    // определяется с помощью методов Note#equals и Note#hashcode.

    private static final PatientRepositoryImpl SINGLETON = new PatientRepositoryImpl();   // Используем паттерн singleton,
    // то есть когда мы создаем внутри класса ровно 1 объект
    // на все приложение и потом выдаем его другим классам, чтобы они его использовали.
    // При этом прячем конструктор, делая его приватным.

    private PatientRepositoryImpl() {}

    public static PatientRepositoryImpl getSingleton() {
        return SINGLETON;
    }

    @Override
    public Set<Patient> findAll() {
        return NOTES;
    }

    @Override
    public void save(Patient patient) {
        NOTES.add(patient);
    }

    @Override
    public void remove(Patient patient) {
        NOTES.remove(patient);
    }

    @Override
    public void update(Patient patient){}
}
