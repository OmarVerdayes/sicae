
package mx.edu.utez.sicae.services;

import mx.edu.utez.sicae.models.group.Group;
import mx.edu.utez.sicae.models.group.GroupRepository;
import mx.edu.utez.sicae.models.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class GroupService {
    @Autowired
    private GroupRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Group>> getAll(){
        return new CustomResponse<>(this.repository.findAll(),false,200,"Ok");
    }

    @Transactional(readOnly = true)
    public CustomResponse<Group> getOne(Long id){
        return new CustomResponse<>(this.repository.findById(id).get(),false,200,"OK");
    }
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Group>insert(Group group){
        return  new CustomResponse<>(this.repository.saveAndFlush(group),false,200,"Grupo registrado correctamente");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Group> update(Group group){
        if(!this.repository.existsById(group.getId()))
            return new CustomResponse<>(null,true,400,"Grupo no existe");

        return new CustomResponse<>(
                this.repository.saveAndFlush(group),false,200,"Grupo actualizado coreectamente"
        );
    }

   /* @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Boolean> changeStatus(Group Group){
        if(this.repository.existsById(Group.getId()))
            return new CustomResponse<>(null,true,400,"La subcategoria no existe");
        return new CustomResponse<>(
                this.repository.findById(Group.getStatus(),Group.getId()),false,200,"Asistencia actualizada correctamente"
        );
    }*/
}
