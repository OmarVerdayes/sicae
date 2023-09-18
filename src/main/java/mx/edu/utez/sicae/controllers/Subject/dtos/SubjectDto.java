package mx.edu.utez.sicae.controllers.Subject.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sicae.models.subject.Subject;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SubjectDto {
    private Long id;
    private String acronim;
    private String name;

    public Subject castToSubject(){return new Subject(getId(),getAcronim(),getName());}

}
