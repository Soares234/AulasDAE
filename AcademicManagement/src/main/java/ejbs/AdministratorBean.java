package ejbs;

import entities.Administrator;
import entities.Course;
import entities.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AdministratorBean {
    @PersistenceContext
    EntityManager em;
    public void create(String username, String password ,  String email, String name){
            Administrator administrator = new Administrator(username, password, email, name);;
            em.persist(administrator);
    }
    public Student findStudent(String username) {return em.find(Student.class, username);}
    public List<Student> getAllStudents() {
        // remember, maps to: “SELECT s FROM Student s ORDER BY s.name”
        return (List<Student>) em.createNamedQuery("getAllStudents").getResultList();
    }

}
