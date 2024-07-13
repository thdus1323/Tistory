package site.metacoding.blogv3.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUserName() {
        String user1 = "ssar";
        User user = userRepository.findByUserName(user1);
        System.out.println("user = " + user);

    }
}