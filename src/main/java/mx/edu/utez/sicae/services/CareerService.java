
package mx.edu.utez.sicae.services;


import mx.edu.utez.sicae.models.career.Career;
import mx.edu.utez.sicae.models.career.CareerRepository;
import mx.edu.utez.sicae.models.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class CareerService {
    @Autowired
    CareerRepository repository;
    @Transactional(readOnly=true)
    public CustomResponse<List<Career>> getAll(){
        return new CustomResponse<>(
                this.repository.findAll(),false,200, "OK"
        );
    }
    @Transactional(readOnly = true)
    public CustomResponse<Career> getOne(Long id){
        return new CustomResponse<>(this.repository.findById(id).get(),false,200,"OK");
    }
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Career> insert(Career career){
        return new CustomResponse<>(this.repository.saveAndFlush(career), false,200,"Carrera registrada!");
    }
    @Transactional(rollbackFor =SQLException.class )
    public CustomResponse<Career> update(Career career){
        if(!this.repository.existsById(career.getId()))
            return new CustomResponse<>(null,true,400,"La carrera no existe");

        return new CustomResponse<>(this.repository.saveAndFlush(career),false,200,"Carrera actualizada");
    }

}