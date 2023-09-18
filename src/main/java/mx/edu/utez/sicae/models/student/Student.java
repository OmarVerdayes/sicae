package mx.edu.utez.sicae.models.student;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sicae.models.group.Group;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private String password;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
/*
    //@OneToMany
    //private List<Asistence> asistences;
*/
}

