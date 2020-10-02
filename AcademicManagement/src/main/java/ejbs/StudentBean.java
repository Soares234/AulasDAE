package ejbs;

import entities.Course;
import entities.Student;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class StudentBean {
    @PersistenceContext
    EntityManager em;
    public void create(String username, String password ,  String email, String name,int courseId){
        Course course=em.find(Course.class,courseId);
        if (course!=null) {
            Student s = new Student(username, password, name, email, course);
            course.addStudent(s);
            em.persist(s);
        }
    }
    public Student findStudent(String username) {return em.find(Student.class, username);}
    public List<Student> getAllStudents() {
        // remember, maps to: “SELECT s FROM Student s ORDER BY s.name”
        return (List<Student>) em.createNamedQuery("getAllStudents").getResultList();
    }


}

