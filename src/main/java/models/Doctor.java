package models;

import java.util.Objects;

public class Doctor {
    public static int idConst = 0;
    private final int id = idGen();
    private final String name;

    private int idGen() {
        return idConst++;
    }

    public Doctor(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return id == doctor.id && Objects.equals(name, doctor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
