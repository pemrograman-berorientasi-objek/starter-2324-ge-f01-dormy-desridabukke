package pbo.f01.model;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    private String id;
    private String name;
    private int entranceYear;
    private String gender;

    @ManyToOne
    @JoinColumn(name = "dorm_id")
    private Dorm dorm;

    // constructors
    public Student() {}

    public Student(String id, String name, int entranceYear, String gender) {
        this.id = id;
        this.name = name;
        this.entranceYear = entranceYear;
        this.gender = gender;
    }

    // getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEntranceYear() {
        return entranceYear;
    }

    public void setEntranceYear(int entranceYear) {
        this.entranceYear = entranceYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Dorm getDorm() {
        return dorm;
    }

    public void setDorm(Dorm dorm) {
        this.dorm = dorm;
    }

    public Set<Student> getStudents() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStudents'");
    }
}