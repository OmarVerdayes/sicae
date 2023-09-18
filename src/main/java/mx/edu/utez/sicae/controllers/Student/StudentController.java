package mx.edu.utez.sicae.controllers.Student;

import mx.edu.utez.sicae.controllers.Student.Dtos.StudentDto;
import mx.edu.utez.sicae.models.student.Student;
import mx.edu.utez.sicae.models.utils.CustomResponse;
import mx.edu.utez.sicae.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins =  {"*"})
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Student>>> getAll(){
        return new ResponseEntity<>(this.studentService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Student>> getOne(@PathVariable("id")String id){
            return  new ResponseEntity<>(this.studentService.getOne(id),HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<CustomResponse<Student>>insert(@Valid @RequestBody StudentDto studentDto){
        return new ResponseEntity<>(this.studentService.insert(studentDto.castToStudent()),HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<CustomResponse<Student>>update(@Valid @RequestBody StudentDto studentDto){
        return new ResponseEntity<>(this.studentService.update(studentDto.castToStudent()),HttpStatus.CREATED);
    }
}
