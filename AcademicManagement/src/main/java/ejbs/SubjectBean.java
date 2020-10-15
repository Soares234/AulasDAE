package ejbs;

import entities.Course;
import entities.Student;
import entities.Subject;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class SubjectBean {
    @PersistenceContext
    EntityManager em;
    public void create(int code, String name, int courseCode, int courseYear, int scholarYear,List<Student> students){
        Course course = em.find(Course.class,courseCode);
        if (course!=null) {
            Subject subject = new Subject(code, name, course, courseYear, scholarYear);
            for (Student student : students) {
                subject.addStudent(student);
            }
            em.persist(subject);
            course.addSubject(subject);
        }
        }
    public List<Subject> getSubjectsByCourseID(int id){
        return new ArrayList(em.find(Course.class,id).getSubjects());
    }
    public boolean enrollStudentInSubject(int subjectCode, String username){
        Student student = em.find(Student.class,username);
        Subject subject = em.find(Subject.class,subjectCode);

        if (student!=null && subject!= null){
            if (student.getCourse().equals(subject.getCourse()) && !student.getSubjects().contains(subject)){
                student.addSubject(subject);
                subject.addStudent(student);
                return true;
            }
        }
        return false;
    }
    public List<Subject> getAllSubjects() {
        // remember, maps to: “SELECT s FROM Student s ORDER BY s.name”
        return (List<Subject>) em.createNamedQuery("getAllSubjects").getResultList();
    }
}
