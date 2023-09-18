package mx.edu.utez.sicae.models.asistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sicae.controllers.Asistence.dtos.AsistenceResponse;
import mx.edu.utez.sicae.models.qr.Qr;
import mx.edu.utez.sicae.models.student.Student;

@NamedNativeQuery(
        name="Asistence.getByClas",
        query="SELECT a.id, a.`date`, a.`status`, a.qr_id, a.student_id, s.`name`, s.lastname \n" +
                "from asistences a INNER JOIN students s \n" +
                "INNER JOIN qrs q on q.id=a.qr_id \n" +
                "INNER JOIN clases c on c.id=q.class_id \n" +
                "WHERE c.id= :id AND a.student_id=s.id AND q.id=a.qr_id AND c.id=q.class_id",
        //query = "SELECT * from asistences WHERE id= :id",
        resultSetMapping = "Mapping.AsistenceResponse")
@SqlResultSetMapping(name="Mapping.AsistenceResponse",
classes = @ConstructorResult(targetClass = AsistenceResponse.class,
columns = {
        @ColumnResult(name ="id"),
        @ColumnResult(name="date"),
        @ColumnResult(name="status"),
        @ColumnResult(name="qr_id"),
        @ColumnResult(name="student_id"),
        @ColumnResult(name="name"),
        @ColumnResult(name="lastname")}))
@Entity
@Table(name = "asistences")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Asistence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String date;
    private int status;

    /*@Column(nullable = false)
    private Boolean status;*/
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "qr_id")
    private Qr qr;
    /*
    @ManyToMany
    @JoinTable(name = "asistence_qr", joinColumns = @JoinColumn(name = "qr_id"),inverseJoinColumns = @JoinColumn(name = "asistence_id"))
    private Set<Asistence> asistences;
     */



}

