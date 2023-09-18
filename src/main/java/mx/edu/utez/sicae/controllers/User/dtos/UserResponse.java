package mx.edu.utez.sicae.controllers.User.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sicae.models.user.User;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserResponse {
    private String email;
    private String password;
    private String name;
    private String lastname;
    private int role;
    private int status;
    private List<Long> id_clases;

    public UserResponse castToResponse (User oldUser){
        UserResponse user= new UserResponse();
        user.setEmail(oldUser.getEmail());
        user.setPassword(oldUser.getPassword());
        user.setName(oldUser.getName());
        user.setLastname(oldUser.getLastname());
        user.setStatus(oldUser.getStatus());
        user.setRole(oldUser.getRole());
        List<Long>ids= new ArrayList<>();
        for(int i=0;i<oldUser.getClases().size();i++){
            ids.add(oldUser.getClases().get(i).getId());
        }
        user.setId_clases(ids);
        return user;
    }
}
