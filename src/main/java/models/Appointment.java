package models;

import java.util.Objects;

public class Appointment {
    private final int idDoctor;
    private final int idPatient;
    private String nameDoctor;
    private String namePatient;
    private final String date;

    public StatusList status;

    public Appointment(int idDoctor, int idPatient, String date) {
        this.idDoctor = idDoctor;
        this.idPatient = idPatient;
        this.date = date;
        status = StatusList.NEW;
    }

    public String getNameDoctor() {
        return nameDoctor;
    }

    public String getNamePatient() {
        return namePatient;
    }

    public StatusList getStatus() {
        return status;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setNameDoctor(String nameDoctor) {
        this.nameDoctor = nameDoctor;
    }

    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }

    public void setStatus(StatusList status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment appointment = (Appointment) o;
        return Objects.equals(nameDoctor, appointment.nameDoctor) && Objects.equals(namePatient, appointment.namePatient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameDoctor, namePatient);
    }
}
