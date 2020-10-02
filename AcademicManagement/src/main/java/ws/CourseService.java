package ws;

import dtos.CourseDTO;
import dtos.StudentDTO;
import ejbs.CourseBean;
import ejbs.StudentBean;
import entities.Course;
import entities.Student;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/courses") // relative url web path forthis service
@Produces({MediaType.APPLICATION_JSON}) // injects header “Content-Type: application/json”
@Consumes({MediaType.APPLICATION_JSON}) // injects header “Accept: application/json”

public class CourseService {
    @EJB
    CourseBean cb;

    private CourseDTO toDTO(Course course) {
        return new CourseDTO(course.getName(),course.getCode());
    }
    private List<CourseDTO> toDTOs(List<Course> courses) {
        return courses.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GET // means: to call this endpoint, we need to use the HTTP GET method
    @Path("/") // means: the relative url path is “/api/students/”
    public List<CourseDTO> getAllStudentsWS() {
        return toDTOs(cb.getAllCourses());
    }

 /*   @POST
    @Path("/")
    public Response createNewStudent (StudentDTO studentDTO){
        studentBean.create(studentDTO.getUsername(),studentDTO.getPassword(),studentDTO.getName(),studentDTO.getEmail(),studentDTO.getCourseCode());
        Student newStudent = studentBean.findStudent(studentDTO.getUsername());
        if(newStudent==null)
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        return Response.status(Response.Status.CREATED).entity(toDTO(newStudent)).build();}*/
}
