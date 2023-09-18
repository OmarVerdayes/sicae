
package mx.edu.utez.sicae.models.clas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sicae.models.group.Group;
import mx.edu.utez.sicae.models.subject.Subject;
import mx.edu.utez.sicae.models.user.User;

@Entity
@Table(name = "clases")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Clas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "boolean default true")
    private int status;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

}