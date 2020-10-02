package entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
        @NamedQuery(name = "getAllStudents",query = "SELECT s FROM Student s ORDER BY s.name" // JPQL)
        )})
@Table(name="STUDENTS")
public class Student {
    @Id
    public String username;
    @NotNull
    public String password;
    @NotNull
    @Email
    public String email;
    @NotNull
    public String name;
    @ManyToOne
    @JoinColumn(name="COURSE_CODE")
    @NotNull
    private Course course;

    public Student() {
    }

    public Student(String username, String password, String email, String name,Course course) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}