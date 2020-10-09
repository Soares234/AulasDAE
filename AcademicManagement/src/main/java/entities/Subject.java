package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SUBJECTS",
uniqueConstraints = @UniqueConstraint(columnNames = {"NAME","COURSE_CODE","COURSE_YEAR","SCHOLAR_YEAR"}))
@NamedQueries({
        @NamedQuery(name = "getAllSubjects",query = "SELECT s FROM Subject s ORDER BY s.course.name,s.scholarYear,s.courseYear" // JPQL)
        )})
public class Subject {
    @Id
    private int code;
    private String name;
    @ManyToOne
    @JoinColumn(name="COURSE_CODE")
    @NotNull
    private Course course;
    @Column(name = "COURSE_YEAR")
    private int courseYear;
    @Column(name = "SCHOLAR_YEAR")
    private int scholarYear;
    @ManyToMany(mappedBy = "subjects")
    private Set<Student> students;
    @ManyToMany(mappedBy = "subjects")
    private Set<Teacher> teachers;

    public Subject() {
        students= new HashSet<>();
    }

    public Subject(int code, String name, Course course, int courseYear, int scholarYear) {
        this.code = code;
        this.name = name;
        this.course = course;

        this.courseYear = courseYear;
        this.scholarYear = scholarYear;
        this.students= new HashSet<>();
    }

    public void setCode(int code) {
        this.code = code;
    }
    public void addStudent(Student student){
        this.students.add(student);
    }
    public void removeStudent(Student student){
        this.students.remove(student);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(int courseYear) {
        this.courseYear = courseYear;
    }

    public int getScholarYear() {
        return scholarYear;
    }

    public void setScholarYear(int scholarYear) {
        this.scholarYear = scholarYear;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public int getCode() {
        return code;
    }
}
