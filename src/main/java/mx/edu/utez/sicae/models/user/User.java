
package mx.edu.utez.sicae.models.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sicae.models.clas.Clas;

import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    private String email;
    @Column()
    private String name;
    @Column()
    private String lastname;
    @Column (columnDefinition = "text",nullable = false)
    private String password;
    @Column( nullable = false)
    //0=admin, 1=teacher
    private int role;
    private int status;
    @Column(nullable = true)
    @OneToMany
    private List<Clas> clases;
}

