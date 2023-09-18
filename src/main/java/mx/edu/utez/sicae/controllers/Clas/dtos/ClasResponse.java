package mx.edu.utez.sicae.controllers.Clas.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sicae.models.clas.Clas;
import mx.edu.utez.sicae.models.group.Group;
import mx.edu.utez.sicae.models.subject.Subject;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ClasResponse {
    private Long id;
    private int status;
    private Group group;
    private String emailTeacher;
    private String nameTeacher;
    private Subject subject;

    public ClasResponse castToResponse(Clas oldClas){
        ClasResponse clas= new ClasResponse();
        clas.setId(oldClas.getId());
        clas.setStatus(oldClas.getStatus());
        clas.setGroup(oldClas.getGroup());
        clas.setEmailTeacher(oldClas.getUser().getEmail());
        clas.setNameTeacher(oldClas.getUser().getName()+" "+oldClas.getUser().getLastname());
        clas.setSubject(oldClas.getSubject());
        return clas;
    }

}
