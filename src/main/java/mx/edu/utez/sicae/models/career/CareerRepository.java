package mx.edu.utez.sicae.models.career;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface CareerRepository extends JpaRepository <Career, Long>{
    @Query(value = "UPDATE careers SET name=:name WHERE id=:id", nativeQuery = true)
    boolean updateById(@Param("name") String name, @Param("id") Long id);

    boolean existsByName(String name);
}

