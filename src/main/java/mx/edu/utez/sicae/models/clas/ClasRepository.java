package mx.edu.utez.sicae.models.clas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClasRepository extends JpaRepository<Clas,Long> {
    @Query(value = "UPDATE clases SET status=:status WHERE id=:id",nativeQuery = true)
    boolean updateById(@Param("status")int status, @Param("id") Long id);

    @Modifying
    @Query(value = "UPDATE users_clases SET user_email=:email WHERE clases_id=:clas",nativeQuery = true)
    @Transactional
    void updateClasUser(@Param("email")String email,@Param("clas")Long clas);
    @Modifying
    @Query(value = "UPDATE clases SET teacher_id=:email WHERE id=:clas",nativeQuery = true)
    @Transactional
    void updateUserClas(@Param("email")String email,@Param("clas")Long clas);
}
