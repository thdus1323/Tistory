package site.metacoding.blogv3.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void updatePassword(UserRequest.ChangePasswordDTO reqDTO, User sessionUser){
        User user = userRepository.findByUserName(sessionUser.getUserName());
        if(user != null){
            if(user.getUserPassword().equals(reqDTO.getUserPassword())){
                user.setUserPassword(reqDTO.getNewPassword());
//                userRepository.save(user);
            }else {
                throw new RuntimeException("비밀번호가 틀렸습니다.");
            }
            //영속화된 객체 수정은 자동 쿼리 짜준다. 더티체킹-v
        }
    }
}
