package ejbs;

import entities.Course;
import entities.Student;
import entities.Subject;
import entities.Teacher;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class TeacherBean {
    @PersistenceContext
    EntityManager em;
    public void create(String username, String password , String email, String name,String office, List<Subject> subjects){
        Teacher teacher = new Teacher(username,password,email,name,office);
        for (Subject subject:subjects) {
            teacher.addSubject(subject);
        }
        em.persist(teacher);
    }
}
