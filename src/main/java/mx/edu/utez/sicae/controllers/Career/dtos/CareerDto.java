package mx.edu.utez.sicae.controllers.Career.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sicae.models.career.Career;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CareerDto {
    private Long id;
    @NotEmpty(message = "Campo Obligatorio")
    private String name;
    private String acronim;

    public Career castToCareer(){
        return new Career(getId(), getAcronim(), getName());
    }
}

