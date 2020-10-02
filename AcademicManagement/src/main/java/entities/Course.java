package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="COURSES",
        uniqueConstraints = @UniqueConstraint(columnNames = {"NAME"}))
@NamedQueries({
        @NamedQuery(name = "getAllCourses",query = "SELECT c FROM Course c ORDER BY c.name" // JPQL)
        )})
public class Course {
    @Id
    private int code;
    @NotNull
    private String name;
    @OneToMany(mappedBy = "course", cascade = CascadeType.REMOVE)
    private List<Student> students;

    public Course() {
        this.students = new ArrayList<>();

    }
    public void addStudent(Student student){
        students.add(student);
    }
    public void removeStudent(Student student){
        students.remove(student);
    }

    public Course(int code, String name) {
        this.code = code;
        this.name = name;
        this.students = new ArrayList<>();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int id) {
        this.code = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
