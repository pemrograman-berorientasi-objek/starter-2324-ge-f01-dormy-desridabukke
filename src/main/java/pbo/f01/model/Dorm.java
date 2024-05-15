package pbo.f01.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dorm") // Tambahkan anotasi @Table untuk memastikan nama tabel benar
public class Dorm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Gunakan GenerationType.AUTO
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "gender")
    private String gender;
    
    @Column(name = "capacity")
    private int capacity;

    @OneToMany(mappedBy = "dorm", cascade = CascadeType.ALL) // Tambahkan cascade jika diperlukan
    private List<Student> students;

    // Constructor
    public Dorm() {}

    public Dorm(String name, int capacity, String gender) {
        this.name = name;
        this.capacity = capacity;
        this.gender = gender;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}