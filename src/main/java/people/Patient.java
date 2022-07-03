package people;

import java.time.Instant;
import java.util.Objects;

public class Patient {
    public static int idConst = 0;
    public String name;
    private final int id = idGen();
    private final Instant creationDate;
    private Instant updateDate;

    private int idGen() {
        return idConst++;
    }

    public Patient(String name) {
        this.name =name;
        creationDate = Instant.now();
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }



    public Instant getCreationDate() {
        return creationDate;
    }

    public Instant getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Instant updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id && Objects.equals(name, patient.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
