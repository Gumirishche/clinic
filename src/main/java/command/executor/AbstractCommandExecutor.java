package command.executor;

import people.Doctor;
import people.Patient;
import repository.DoctorRepository;
import repository.PatientRepository;
import repository.impl.DoctorRepositoryImpl;
import repository.impl.PatientRepositoryImpl;

import java.util.Optional;

public abstract class AbstractCommandExecutor implements CommandExecutor {

    protected final DoctorRepository doctor = DoctorRepositoryImpl.getSingleton();
    protected final PatientRepository patient = PatientRepositoryImpl.getSingleton();

    protected Optional<Doctor> findDoctor(String name) {
        for (Doctor doctor1 : doctor.findAll()) {
            if (doctor1.getName().equals(name)) {
                return Optional.of(doctor1);
            }
        }

        return Optional.empty();
    }
    protected Optional<Patient> findPatient(String name) {
        for (Patient patient1 : patient.findAll()) {
            if (patient1.getName().equals(name)) {
                return Optional.of(patient1);
            }
        }

        return Optional.empty();
    }

    protected void updatePatient(String name,String newName) {
        for (Patient patient1 : patient.findAll()) {
            if (patient1.getName().equals(name)) {
                patient1.setName(newName);
            }
        }
    }
}
