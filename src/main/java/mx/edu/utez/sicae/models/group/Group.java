package mx.edu.utez.sicae.models.group;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sicae.models.career.Career;

@Entity
@Table(name = "`groups`")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int degree;
    private String letter;
    private int year;
    /*@Column
        private Boolean status;*/
    @ManyToOne
    @JoinColumn(name = "career_id")
    private Career career;

    /*
    @OneToMany
    private List<Clas> clases;

    @ManyToMany
    @JoinTable(name = "student_class", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "clas_id"))
    private Set<Clas> classes;
     */


}

