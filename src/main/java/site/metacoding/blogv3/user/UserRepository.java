package site.metacoding.blogv3.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {

    //회원가입

    //로그인
    @Query("SELECT u FROM User u WHERE u.userName = :userName AND u.userPassword = :userPassword")
    Optional<User> findByUsernameAndPassword(@Param("userName") String userName, @Param("userPassword") String userPassword);
}

