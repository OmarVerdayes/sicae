package mx.edu.utez.sicae.controllers.Asistence.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sicae.models.asistence.Asistence;

import javax.validation.constraints.NotEmpty;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AsistenceDto {
    @NotEmpty(message = "Campo Obligatorio")
    private Long id;
    private String date;
    private int status;
    public Asistence castToAsistence(){
        //return  new Asistence(getId(),getDate(),getStatus(), null,null);
        return  new Asistence(getId(),getDate(),getStatus(), null,null);
    }

}
