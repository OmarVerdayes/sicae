package mx.edu.utez.sicae.services;

import mx.edu.utez.sicae.controllers.User.dtos.UserResponse;
import mx.edu.utez.sicae.models.user.User;
import mx.edu.utez.sicae.models.user.UserRepository;
import mx.edu.utez.sicae.models.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;
    @Transactional(readOnly = true)
    public CustomResponse<List<UserResponse>> getAll(){
        List<UserResponse>listUsers= new ArrayList<>();
        List<User> list=this.repository.findAll();
        for(int i=0;i<list.size();i++){
            UserResponse user= new UserResponse().castToResponse(list.get(i));
            listUsers.add(user);
            System.out.println(listUsers.get(i).getEmail());
        }
        return new CustomResponse<>(listUsers,true,200,"OK");
    }

    @Transactional(readOnly = true)
    public CustomResponse<UserResponse> getOne(String email){
        User oldUser=this.repository.findById(email).get();
        UserResponse user=new UserResponse().castToResponse(oldUser);
        return new CustomResponse<>(user,false,200,"OK");
    }
    @Transactional(rollbackFor ={SQLException.class} )
    public CustomResponse<User> insert(User user){
        if (this.repository.existsById(user.getEmail()))
            return new CustomResponse<>(null,true,400,"Error usuario ya registrado");

        String contrasenaEncrip=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(contrasenaEncrip);

        return new CustomResponse<>(this.repository.saveAndFlush(user),false,200,"Usuario Registrado");
    }
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<User>update(User user){
        if(!this.repository.existsById(user.getEmail()))
            return new CustomResponse<>(null,true,400,"Error usuario no encontrado");

        String contrasenaEncrip=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(contrasenaEncrip);

        return new CustomResponse<>(this.repository.saveAndFlush(user),false,200,"Usuario Actualizado");
    }
    @Transactional(rollbackFor = {SQLException.class})
    public void updateClases(Long clas, String email){
        this.repository.insertUserClas(email,clas);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public  CustomResponse<Boolean> changeStatus(User user){
        if (!this.repository.existsById(user.getEmail()))
            return new CustomResponse<>(null,true,400,"Error Usuario no encontrado");
        return new CustomResponse<>(this.repository.updateByEmail(user.getStatus(), user.getEmail()),false,200,"Estado actualizado!");
    }

}
