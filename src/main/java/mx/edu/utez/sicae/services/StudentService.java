package mx.edu.utez.sicae.services;

import mx.edu.utez.sicae.models.student.Student;
import mx.edu.utez.sicae.models.student.StudentRepository;
import mx.edu.utez.sicae.models.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;
    @Transactional(readOnly = true)
    public CustomResponse<List<Student>>getAll(){
        return new CustomResponse<>(this.repository.findAll(),false,200,"OK");
    }
    @Transactional(readOnly = true)
    public  CustomResponse<Student>getOne(String email){
        return new CustomResponse<>(this.repository.findById(email).get(),false,200,"OK");
    }
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Student> insert(Student student){
        //System.out.println(student.getId());
        if(this.repository.existsById(student.getId()))
            return new CustomResponse<>(null,true,400,"Error el estudiante ya existe");
        return new CustomResponse<>(this.repository.saveAndFlush(student),false,200,"Estudiante creado con éxito");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public  CustomResponse<Student>update(Student student){
        if(!this.repository.existsById(student.getId()))
            return new CustomResponse<>(null,true,400,"Error el estudiante no eciste");
        return new CustomResponse<>(this.repository.saveAndFlush(student),false,200,"Estudiante actualizado");
    }
}
