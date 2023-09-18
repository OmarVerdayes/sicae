
package mx.edu.utez.sicae.controllers.Group.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sicae.models.career.Career;
import mx.edu.utez.sicae.models.group.Group;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GroupDto {

    private Long id;
    @NotEmpty(message = "Campo obligatorio")
    private int degree;
    private String letter;
    private int year;
    private Career career;

    public Group castToGroup(){return new Group(getId(),getDegree(),getLetter(),getYear(),getCareer());}
}

