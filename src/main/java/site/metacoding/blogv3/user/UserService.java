package site.metacoding.blogv3.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    //회원가입
    public void joinUser(UserRequest.JoinFormDTO reqDTO){
        User user = new User();
        user.setUserName(reqDTO.getUserName());
        user.setUserPassword(reqDTO.getUserPassword());
        user.setUserEmail(reqDTO.getUserEmail());

        userRepository.save(user);
    }

    //로그인
    public User loginUser(UserRequest.LoginFormDTO reqDTO) {
        Optional<User> sessionUserOptional = userRepository.findByUsernameAndPassword(reqDTO.getUserName(), reqDTO.getUserPassword());
        if (sessionUserOptional.isPresent()) {
            return sessionUserOptional.get();
        } else {
            throw new RuntimeException("로그인 실패: 아이디 혹은 패스워드가 틀렸습니다.");
        }
    }

}
