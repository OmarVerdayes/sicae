package mx.edu.utez.sicae.controllers.Group;

import mx.edu.utez.sicae.controllers.Group.dtos.GroupDto;
import mx.edu.utez.sicae.models.group.Group;
import mx.edu.utez.sicae.models.utils.CustomResponse;
import mx.edu.utez.sicae.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/group")
@CrossOrigin(origins =  {"*"})
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Group>>> getAll(){
        return new ResponseEntity<>(this.groupService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Group>> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.groupService.getOne(id),HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<CustomResponse<Group>> insert(@Valid @RequestBody GroupDto groupDto){
        return new ResponseEntity<>(this.groupService.insert(groupDto.castToGroup()),HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<CustomResponse<Group>> update(@Valid @RequestBody GroupDto groupDto){
        return new ResponseEntity<>(this.groupService.update(groupDto.castToGroup()),HttpStatus.CREATED);
    }

    /*@PatchMapping("/")
    public ResponseEntity<CustomResponse<Boolean>>
    enableOrDisable(@RequestBody GroupDto groupDto){
        return  new ResponseEntity<>(this.groupService.changeStatus(groupDto.castToGroup()),HttpStatus.OK);
    }*/

}

