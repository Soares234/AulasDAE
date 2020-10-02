package ejbs;

import entities.Course;
import entities.Student;

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
    @PostConstruct
    public void populateDB(){
        courseBean.create(1,"Engenharia Informatica", new ArrayList<>());
        studentBean.create("Soares234","1234","Ricardo Soares","r.soares@email.pt",1);
        studentBean.create("Andre","1234","Andre Lopes","a.lopes@email.pt",1);
        studentBean.create("Fred","1234","Fred Silva","f.silva@email.pt",1);
        studentBean.create("Xico","1234","Xico Silva","x.silva@email.pt",1);

    }
}
