package ejbs;

import entities.Administrator;
import entities.Course;
import entities.Student;
import entities.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.ArrayList;

@Singleton(name = "ConfigEJB")
@Startup
public class ConfigBean {
    @EJB
    StudentBean studentBean;
    @EJB
    CourseBean courseBean;
    @EJB
    SubjectBean subjectBean;
    @EJB
    AdministratorBean administratorBean;
    @EJB
    TeacherBean teacherBean;
    @PostConstruct
    public void populateDB(){
        administratorBean.create("Admin","1234","admin@admin.pt","Administrador");
        teacherBean.create("Professor","1234","profRui@maildaescola.pt","Prof Rui","Office",new ArrayList<>());
        courseBean.create(1,"Engenharia Informatica", new ArrayList<>());
        subjectBean.create(1,"Projeto Informático",1,3,2,new ArrayList<>());
        subjectBean.create(1,"IS",1,3,2,new ArrayList<>());
        studentBean.create("Soares234","1234","Ricardo Soares","r.soares@email.pt",1);
        studentBean.create("Andre","1234","Andre Lopes","a.lopes@email.pt",1);
        studentBean.create("Fred","1234","Fred Silva","f.silva@email.pt",1);
        studentBean.create("Xico","1234","Xico Silva","x.silva@email.pt",1);
        subjectBean.enrollStudentInSubject(1,"Soares234");
        subjectBean.enrollStudentInSubject(1,"Andre");
        subjectBean.enrollStudentInSubject(1,"Fred");
        subjectBean.create(1,"EC",1,3,2,new ArrayList<>());

    }
}
