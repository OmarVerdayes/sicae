package mx.edu.utez.sicae.models.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {
    boolean existsByName(String name);

    @Query(value = "SELECT * from students WHERE group_id=:group",nativeQuery = true)
    List<Student> students(@Param("group")Long group);
}


