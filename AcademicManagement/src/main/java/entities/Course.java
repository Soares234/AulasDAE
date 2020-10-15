package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

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
    @OneToMany(mappedBy = "course", cascade = CascadeType.REMOVE)
    private Set<Subject> subjects;

    public Course() {
        this.students = new ArrayList<>();
        this.subjects= new HashSet<>();

    }
    public void addStudent(Student student){
        students.add(student);
    }
    public void removeStudent(Student student){
        students.remove(student);
    }
    public void addSubject(Subject subject){ subjects.add(subject); }
    public void removeSubject(Subject subject){
        subjects.remove(subject);
    }

    public Course(int code, String name) {
        this.code = code;
        this.name = name;
        this.students = new ArrayList<>();
        this.subjects = new HashSet<>();
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
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

    @Override
    public int hashCode(){
        return Objects.hash(code);
    }


    @Override
    public boolean equals(Object o){
        if (this==o) return  true;
        if (o==null || this.getClass() !=o.getClass()) return false;
        Course course = (Course) o;
        return this.code == course.code;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
