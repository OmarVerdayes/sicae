package mx.edu.utez.sicae.models.qr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QrRepository extends JpaRepository<Qr,Long> {
    @Query(value = "UPDDATE qrs SET status=:status WHERE id=:id ",nativeQuery = true)
    boolean updateById(@Param("status") int status, @Param("id")Long id);
}
