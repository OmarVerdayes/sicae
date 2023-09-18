package mx.edu.utez.sicae.controllers.Qr.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sicae.models.qr.Qr;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class QrResponse {
    private Long id;
    private String date;
    private int status;
    private Long idClas;

    public QrResponse castToResponse(Qr oldQr){
        QrResponse qr=new QrResponse();
        qr.setId(oldQr.getId());
        qr.setDate(oldQr.getDate());
        qr.setStatus(oldQr.getStatus());
        qr.setIdClas(oldQr.getClas().getId());
        return qr;
    }
}
