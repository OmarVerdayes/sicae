package mx.edu.utez.sicae.models.career;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "careers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Career {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String acronim;
    private String name;
    //@OneToMany(mappedBy="group")
    //private List<Group> groups;
}

