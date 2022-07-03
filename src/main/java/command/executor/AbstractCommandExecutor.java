package command.executor;

import models.Appointment;
import models.Doctor;
import models.Patient;
import models.StatusList;
import repository.AppointmentRepository;
import repository.DoctorRepository;
import repository.PatientRepository;
import repository.impl.AppointmentRepositoryImpl;
import repository.impl.DoctorRepositoryImpl;
import repository.impl.PatientRepositoryImpl;

import java.util.Optional;

public abstract class AbstractCommandExecutor implements CommandExecutor {

    private String nameDoctor;
    private String namePatient;
    protected final DoctorRepository doctor = DoctorRepositoryImpl.getSingleton();
    protected final PatientRepository patient = PatientRepositoryImpl.getSingleton();
    protected final AppointmentRepository appointment = AppointmentRepositoryImpl.getSingleton();

    protected Optional<Doctor> findDoctor(String name) {
        for (Doctor doctor1 : doctor.findAll()) {
            if (doctor1.getName().equals(name)) {
                return Optional.of(doctor1);
            }
        }

        return Optional.empty();
    }

    protected Optional<Doctor> findDoctorId(int id) {
        for (Doctor doctor1 : doctor.findAll()) {
            if (doctor1.getId() == id) {
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

    protected Optional<Patient> findPatientId(int id) {
        for (Patient patient1 : patient.findAll()) {
            if (patient1.getId() == id) {
                return Optional.of(patient1);
            }
        }

        return Optional.empty();
    }

    protected Optional<Appointment> findAppointment(int idDoctor, int idPatient) {
        for (Appointment appointment1 : appointment.findAll()) {
            if (appointment1.getIdDoctor() == idDoctor && appointment1.getIdPatient() == idPatient) {
                return Optional.of(appointment1);
            }
        }

        return Optional.empty();
    }

    protected Optional<Appointment> findAppointmentPatient(String patientName) {
        for (Appointment appointment1 : appointment.findAll()) {
            if (appointment1.getNamePatient().equals(patientName)) {
                return Optional.of(appointment1);
            }
        }

        return Optional.empty();
    }

    protected void updatePatient(String name, String newName) {
        for (Patient patient1 : patient.findAll()) {
            if (patient1.getId() == Integer.parseInt(name)) {
                patient1.setName(newName);
            }
        }
    }

    protected void createAppointmentNames(int idDoctor, int idPatient) {
        for (Appointment appointment1 : appointment.findAll()) {
            if (appointment1.getIdDoctor() == idDoctor && appointment1.getIdPatient() == idPatient) {
                nameDoctor(idDoctor);
                namePatient(idPatient);
                appointment1.setNameDoctor(nameDoctor);
                appointment1.setNamePatient(namePatient);
            }
        }
    }

    protected void nameDoctor(int id) {
        for (Doctor doctor1 : doctor.findAll()) {
            if (doctor1.getId() == id) {
                nameDoctor = doctor1.getName();
            }
        }
    }

    protected void namePatient(int id) {
        for (Patient patient1 : patient.findAll()) {
            if (patient1.getId() == id) {
                namePatient = patient1.getName();
            }
        }
    }

    protected void updateAppointment(int idDoctor, int idPatient, StatusList status) {
        for (Appointment appointment1 : appointment.findAll()) {
            if (appointment1.getIdDoctor() == idDoctor && appointment1.getIdPatient() == idPatient) {
                appointment1.setStatus(status);
            }
        }
    }
}
