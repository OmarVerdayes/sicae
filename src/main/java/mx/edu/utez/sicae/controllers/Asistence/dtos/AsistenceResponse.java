package mx.edu.utez.sicae.controllers.Asistence.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AsistenceResponse {
    private Long id;
    private String date;
    private int status;
    private Long qr_id;
    private String student_id;
    private String name;
    private String lastname;
}
