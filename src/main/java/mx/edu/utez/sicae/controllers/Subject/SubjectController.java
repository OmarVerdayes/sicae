package mx.edu.utez.sicae.controllers.Subject;


import mx.edu.utez.sicae.controllers.Subject.dtos.SubjectDto;
import mx.edu.utez.sicae.models.subject.Subject;
import mx.edu.utez.sicae.models.utils.CustomResponse;
import mx.edu.utez.sicae.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/subject")
@CrossOrigin(origins =  {"*"})
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Subject>>> getAll(){
        return new ResponseEntity<>(this. subjectService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Subject>> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(this. subjectService.getOne(id),HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<CustomResponse<Subject>> insert(@Valid @RequestBody SubjectDto subjectDto){
        return new ResponseEntity<>(this. subjectService.insert(subjectDto.castToSubject()),HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<CustomResponse<Subject>> update(@Valid @RequestBody SubjectDto subjectDto){
        return new ResponseEntity<>(this. subjectService.update(subjectDto.castToSubject()),HttpStatus.CREATED);
    }
}
