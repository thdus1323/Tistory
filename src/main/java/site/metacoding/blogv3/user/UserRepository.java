package site.metacoding.blogv3.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //회원가입

    //로그인
    @Query("SELECT u FROM User u WHERE u.userName = :userName AND u.userPassword = :userPassword")
    Optional<User> findByUsernameAndPassword(@Param("userName") String userName, @Param("userPassword") String userPassword);

    //비밀번호 변경
//    @Query("UPDATE User u SET  u.userPassword = :userPassword")
//    User updateUserPassword(@Param("userPassword") String userPassword);

    //비밀번호 변경
    User findByUserName(String userName);

}

