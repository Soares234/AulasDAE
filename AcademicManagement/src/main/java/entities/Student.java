package entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "getAllStudents",query = "SELECT s FROM Student s ORDER BY s.name" // JPQL)
        )})
public class Student extends User{

    @ManyToOne
    @JoinColumn(name="COURSE_CODE")
    @NotNull
    private Course course;
    @ManyToMany
    @JoinTable(name = "SUBJECTS_STUDENTS",
            joinColumns = @JoinColumn(name = "SUBJECT_CODE", referencedColumnName = "CODE"),
            inverseJoinColumns=@JoinColumn(name = "STUDENT_USERNAME", referencedColumnName = "USERNAME"))
    private Set<Subject> subjects;

    public Student() {
        super();
        this.subjects = new HashSet<>();
    }

    public Student(String username, String password, String email, String name,Course course) {
        super(username, password, email, name);
        this.course = course;
        this.subjects = new HashSet<>();
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {

        this.course = course;
    }
    public void addSubject(Subject subject){

        subjects.add(subject);
    }
    public void removeSubject(Subject subject){

        subjects.remove(subject);
    }

}
