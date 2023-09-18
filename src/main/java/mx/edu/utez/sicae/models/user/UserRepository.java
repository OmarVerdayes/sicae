
package mx.edu.utez.sicae.models.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query (value = "UPDATE users SET status=:status WHERE email=:email",nativeQuery = true)
    boolean updateByEmail(@Param("status")int status, @Param("email")String email);
    @Modifying
    @Query(value = "INSERT INTO users_clases(user_email,clases_id) VALUES (:email,:clas)",nativeQuery = true)
    @Transactional
    void insertUserClas(@Param("email")String email,@Param("clas")Long clas);
        //boolean updateByEmail(@Param("email")String email)
        @Modifying
        @Query(value = "UPDATE users SET user_email=:email WHERE clases_id=:clas",nativeQuery = true)
        @Transactional
        void updateClasUser(@Param("email")String email,@Param("clas")Long clas);

    boolean existsByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);

}

