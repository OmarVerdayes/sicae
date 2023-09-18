package mx.edu.utez.sicae.controllers.Student.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sicae.models.asistence.Asistence;
import mx.edu.utez.sicae.models.group.Group;
import mx.edu.utez.sicae.models.student.Student;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StudentDto {
    private List<Asistence> asistences;
    private String password;
    @NotEmpty(message = "Campo obligatorio")
    private String id;
    private String name;
    private String lastname;
    private Group group;

    public Student castToStudent(){
        System.out.println(getId());
        return new Student(
                getId(),
                getName(),
                getLastname(),
                getPassword(),
                getGroup()
        );
    }
}
