package ws;


import dtos.StudentDTO;
import dtos.SubjectDTO;
import ejbs.SubjectBean;
import entities.Student;
import entities.Subject;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/subjects") // relative url web path forthis service
@Produces({MediaType.APPLICATION_JSON}) // injects header “Content-Type: application/json”
@Consumes({MediaType.APPLICATION_JSON}) // injects header “Accept: application/json”

public class SubjectService {
    @EJB
    SubjectBean subjectBean;

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
    private List<SubjectDTO> subjectsToDTOs(List<Subject> subjects){
        return subjects.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GET // means: to call this endpoint, we need to use the HTTP GET method
    @Path("/") // means: the relative url path is “/api/subjects/”
    public List<SubjectDTO> getAllSubjects() {

        return subjectsToDTOs(subjectBean.getAllSubjects());
    }
    @GET
    @Path("{id}/enroll/{username}")
    public Response getStudentSubjects(@PathParam("username") String username,@PathParam("id") int id)
    {
        boolean check = subjectBean.enrollStudentInSubject(id,username);
        if ( check)
        {
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("course/{id}")
    public List<SubjectDTO> getAllSubjects(@PathParam("id")int id){
        return subjectsToDTOs(subjectBean.getSubjectsByCourseID(id)); // IT JUST WORKS
    }
}
