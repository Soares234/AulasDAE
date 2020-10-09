package entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Teacher extends User {
    private String office;
    @ManyToMany
    @JoinTable(name = "SUBJECTS_TEACHERS",
            joinColumns = @JoinColumn(name = "SUBJECT_CODE", referencedColumnName = "CODE"),
            inverseJoinColumns=@JoinColumn(name = "TEACHER_USERNAME", referencedColumnName = "USERNAME"))
    private Set<Subject> subjects;

    public Teacher(String username, @NotNull String password, @NotNull @Email String email, @NotNull String name,String office) {
        super(username, password, email, name);
        this.office=office;
        this.subjects = new HashSet<>();
    }

    public Teacher() {
        super();
    }

    public void addSubject(Subject subject){
        subjects.add(subject);
    }
    public void removeSubject(Subject subject){
        subjects.remove(subject);
    }
    public Teacher(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}
