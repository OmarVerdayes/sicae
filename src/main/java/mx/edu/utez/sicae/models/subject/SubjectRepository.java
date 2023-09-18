package mx.edu.utez.sicae.models.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
    boolean findById(long id);
    boolean existsByName(String name);

}
