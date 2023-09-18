package mx.edu.utez.sicae.controllers.Qr;


import mx.edu.utez.sicae.controllers.Qr.dtos.QrDto;
import mx.edu.utez.sicae.controllers.Qr.dtos.QrResponse;
import mx.edu.utez.sicae.models.qr.Qr;
import mx.edu.utez.sicae.models.utils.CustomResponse;
import mx.edu.utez.sicae.services.QrService;
import mx.edu.utez.sicae.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/qr")
public class QrController {
    @Autowired
    private QrService qrService;
    @Autowired
    private StudentService studentService;

    //-----------------------No se ocupa-----------------------//
    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<QrResponse>>> getAll(){
        return new ResponseEntity<>(this.qrService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<QrResponse>> getOne(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.qrService.getOne(id),HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<CustomResponse<Qr>> insert(@Valid @RequestBody QrDto qeDto){
        return new ResponseEntity<>(this.qrService.insert(qeDto.castToQr()),HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<CustomResponse<Qr>> update(@Valid @RequestBody QrDto qeDto){
        return new ResponseEntity<>(this.qrService.update(qeDto.castToQr()),HttpStatus.CREATED);
    }
    @PatchMapping("/")
    public ResponseEntity<CustomResponse<Boolean>>
    enableOrDisable(@RequestBody QrDto qrDto){
        return  new ResponseEntity<>(this.qrService.changeStatus(qrDto.castToQr()),HttpStatus.OK);
    }
}
