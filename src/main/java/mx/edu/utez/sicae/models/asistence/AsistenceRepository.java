package mx.edu.utez.sicae.models.asistence;

import mx.edu.utez.sicae.controllers.Asistence.dtos.AsistenceResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AsistenceRepository extends CrudRepository<Asistence, Long>, JpaRepository<Asistence,Long> {
    boolean existsById(long id);

    @Modifying
    @Query(value = "INSERT INTO students_asistences(student_id,asistences_id) VALUES(:student,:asistence)",nativeQuery = true)
    void insert(@Param("student")String student, @Param("asistence")Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE asistences SET status=:status WHERE id= :id", nativeQuery = true)
    void changeStatus( @Param("id")Long id, @Param("status")int status);
    @Query(nativeQuery = true)
    List<AsistenceResponse> getByClas(Long id);


}
