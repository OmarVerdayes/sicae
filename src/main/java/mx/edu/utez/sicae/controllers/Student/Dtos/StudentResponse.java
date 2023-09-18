package mx.edu.utez.sicae.controllers.Student.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sicae.models.group.Group;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StudentResponse {
    private String id;
    private String name;
    private String lastname;
    private String password;
    private Group group;

}
