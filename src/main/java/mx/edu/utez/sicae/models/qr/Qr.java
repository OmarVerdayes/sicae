
package mx.edu.utez.sicae.models.qr;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sicae.models.clas.Clas;

@Entity
@Table(name = "qrs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Qr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private int status;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Clas clas;

}

