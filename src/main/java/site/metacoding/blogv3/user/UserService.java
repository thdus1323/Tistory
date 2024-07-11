package site.metacoding.blogv3.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    //회원가입
    public void join(UserRequest.JoinDTO reqDTO){

        // 비밀번호와 비밀번호 확인이 일치하는지 체크
        if (!reqDTO.getUserPassword().equals(reqDTO.getConfirmPassword())) {
            throw new RuntimeException("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        }

        User user = new User();
        user.setUserName(reqDTO.getUserName());
        user.setUserPassword(reqDTO.getUserPassword());
        user.setUserEmail(reqDTO.getUserEmail());
        user.setComfirmUserPassword(reqDTO.getConfirmPassword());

        userRepository.save(user);
    }

    //로그인
    public User login(UserRequest.LoginDTO reqDTO) {
        Optional<User> sessionUserOptional = userRepository.findByUsernameAndPassword(reqDTO.getUserName(), reqDTO.getUserPassword());
        if (sessionUserOptional.isPresent()) {
            return sessionUserOptional.get();
        } else {
            throw new RuntimeException("로그인 실패: 아이디 혹은 패스워드가 틀렸습니다.");
        }
    }

    //비밀번호 변경
    public void changePassword(UserRequest.ChangePasswordDTO reqDTO) {}

}
