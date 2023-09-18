package mx.edu.utez.sicae.controllers.Career;

import mx.edu.utez.sicae.controllers.Career.dtos.CareerDto;
import mx.edu.utez.sicae.models.career.Career;
import mx.edu.utez.sicae.models.utils.CustomResponse;
import mx.edu.utez.sicae.services.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/career")
@CrossOrigin(origins = {"*"})
public class CareerController {
    @Autowired
    CareerService careerService;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Career>>> getAll(){
        return new ResponseEntity<>(this.careerService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Career>> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.careerService.getOne(id),HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<CustomResponse<Career>> insert(@Valid @RequestBody CareerDto careerDto){
        return new ResponseEntity<>(this.careerService.insert(careerDto.castToCareer()),HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<CustomResponse<Career>> update(@Valid @RequestBody CareerDto careerDto){
        return new ResponseEntity<>(this.careerService.update(careerDto.castToCareer()),HttpStatus.CREATED);
    }
}

