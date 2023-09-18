package mx.edu.utez.sicae.services;

import mx.edu.utez.sicae.controllers.Asistence.dtos.AsistenceResponse;
import mx.edu.utez.sicae.models.asistence.Asistence;
import mx.edu.utez.sicae.models.asistence.AsistenceRepository;
import mx.edu.utez.sicae.models.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class AsistenceService {
    @Autowired
    private AsistenceRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Asistence>>getAll(){
        return new CustomResponse<>(this.repository.findAll(),false,200,"Ok");
    }
    @Transactional(readOnly = true)
    public CustomResponse<List<AsistenceResponse>>getById(Long id){
        return new CustomResponse<>(this.repository.getByClas(id),false,200,"OK");
    }

   @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Asistence>insert(Asistence asistence){
        asistence.setStatus(0);
        return  new CustomResponse<>(this.repository.saveAndFlush(asistence),false,200,"Aistencia registrada coreectamente");
   }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Asistence> update(Asistence asistence){
        if(this.repository.existsById(asistence.getId()))
            return new CustomResponse<>(null,true,400,"Asistencia no existe");

        return new CustomResponse<>(
                this.repository.saveAndFlush(asistence),false,200,"Aistencia registrada coreectamente"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public  void changeStatus(Long id, int status){
        this.repository.changeStatus(id, status);
    }


}
