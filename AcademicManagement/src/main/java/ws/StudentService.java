package ws;

import dtos.StudentDTO;
import dtos.SubjectDTO;
import ejbs.StudentBean;
import entities.Course;
import entities.Student;
import entities.Subject;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/students") // relative url web path forthis service
@Produces({MediaType.APPLICATION_JSON}) // injects header “Content-Type: application/json”
@Consumes({MediaType.APPLICATION_JSON}) // injects header “Accept: application/json”

public class StudentService {
    @EJB
    StudentBean studentBean;

    private StudentDTO toDTO(Student student) {
        return new StudentDTO(
                student.getUsername(),
                student.getPassword(),
                student.getName(),
                student.getEmail(),
                student.getCourse().getName(),
                student.getCourse().getCode()
        );
    }
    private List<SubjectDTO> subjectsToDTOs(List<Subject> subjects){
        return subjects.stream().map(this::toDTO).collect(Collectors.toList());
    }
    private SubjectDTO toDTO(Subject subject){
        return new SubjectDTO(
                subject.getCode(),
                subject.getName(),
                subject.getCourse().getCode(),
                subject.getName(),
                subject.getCourseYear(),
                subject.getScholarYear()
        );
    }
    private List<StudentDTO> toDTOs(List<Student> students) {
        return students.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GET // means: to call this endpoint, we need to use the HTTP GET method
    @Path("/") // means: the relative url path is “/api/students/”
    public List<StudentDTO> getAllStudentsWS() {
        return toDTOs(studentBean.getAllStudents());
    }

    @POST
    @Path("/")
    public Response createNewStudent (StudentDTO studentDTO){
        studentBean.create(studentDTO.getUsername(),studentDTO.getPassword(),studentDTO.getName(),studentDTO.getEmail(),studentDTO.getCourseCode());
        Student newStudent = studentBean.findStudent(studentDTO.getUsername());
        if(newStudent==null)
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        return Response.status(Response.Status.CREATED).entity(toDTO(newStudent)).build();}
    @GET
    @Path("{username}")
    public Response getStudentDetails(@PathParam("username") String username)
    {Student student = studentBean.findStudent(username);
    if (student != null)
    {
        return Response.status(Response.Status.OK).entity(toDTO(student)).build();
    }
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("ERROR_FINDING_STUDENT").build();
    }
    @GET
    @Path("{username}/subjects")
    public Response getStudentSubjects(@PathParam("username") String username)
    {Student student = studentBean.findStudent(username);
    if (student != null)
    {
        return Response.status(Response.Status.OK).entity(subjectsToDTOs(new ArrayList<>(student.getSubjects()))).build();
    }
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("ERROR_FINDING_STUDENT").build();
    }
}
