package mx.edu.utez.sicae.controllers.User;

import mx.edu.utez.sicae.controllers.User.dtos.UserDto;
import mx.edu.utez.sicae.controllers.User.dtos.UserResponse;
import mx.edu.utez.sicae.models.user.User;
import mx.edu.utez.sicae.models.utils.CustomResponse;
import mx.edu.utez.sicae.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<UserResponse>>> getAll(){
        return new ResponseEntity<>(this.userService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{email}")
    public ResponseEntity<CustomResponse<UserResponse>>getOne(@PathVariable("email")String email){
        return new ResponseEntity<>(this.userService.getOne(email),HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<CustomResponse<User>> insert(@Valid @RequestBody UserDto userDto){
        return new ResponseEntity<>(this.userService.insert(userDto.castToUser()),HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<CustomResponse<User>>update(@Valid @RequestBody UserDto userDto){
        return new ResponseEntity<>(this.userService.update(userDto.castToUser()),HttpStatus.OK);
    }
    @PatchMapping("/")
    public ResponseEntity<CustomResponse<Boolean>> enableOrDisable(@RequestBody UserDto userDto){
        return new ResponseEntity<>(this.userService.changeStatus(userDto.castToUser()),HttpStatus.OK);
    }
}
