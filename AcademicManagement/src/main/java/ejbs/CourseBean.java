package ejbs;

import entities.Course;
import entities.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CourseBean {
    @PersistenceContext
    EntityManager em;
    public void create(int code,String name,List<Student> students){
        Course course = new Course(code,name);
        for (Student student:students) {
            course.addStudent(student);
        }
            em.persist(course);
    }

    public List<Course> getAllCourses() {
        // remember, maps to: “SELECT s FROM Student s ORDER BY s.name”
        return (List<Course>) em.createNamedQuery("getAllCourses").getResultList();
    }


}