package site.metacoding.blogv3.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
    private final HttpSession session;

    //회원가입
    @PostMapping("/join")
    public String join(@ModelAttribute UserRequest.JoinDTO reqDTO){
        try {
            userService.join(reqDTO);
            System.out.println("reqDTO = " + reqDTO);
            return "/user/loginForm";
        } catch (RuntimeException e) {
            System.out.println("회원가입 오류: " + e.getMessage());
            return "redirect:/joinForm?error=" + e.getMessage(); // 에러 메시지를 포함하여 리다이렉트
        }
    }

    @GetMapping("/join-form")
    public String joinForm() {
        return "/user/joinForm";
    }

    //로그인
    @PostMapping("/login")
    public String login(UserRequest.LoginDTO reqDTO) {
        System.out.println("reqDTO = " + reqDTO);
        User sessionUser = userService.login(reqDTO);
        session.setAttribute("sessionUser", sessionUser);
        System.out.println("sessionUser = " + sessionUser);
        return "redirect:/";
    }

    @GetMapping("login-form")
    public String loginForm() {
        return "/user/loginForm";
    }

    //비밀번호 변경
//    @PostMapping("/s/user")
//    public String update(@ModelAttribute UserRequest.ChangePasswordDTO reqDTO) {
//        System.out.println("reqDTO = " + reqDTO);
//        userService.changePassword(reqDTO);
//        return "redirect:/";
//    }

    @GetMapping("/s/user")
    public String updateForm(HttpSession session, @ModelAttribute UserRequest.ChangePasswordDTO reqDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser != null) {
            reqDTO.setUserName(sessionUser.getUserName());
            reqDTO.setUserEmail(sessionUser.getUserEmail());
        }
        return "/user/updateForm";
    }

    @PostMapping("/updatePassword")
    public String updatePassword(@ModelAttribute UserRequest.ChangePasswordDTO reqDTO, HttpSession session){
        try{
            User sessionUser = (User) session.getAttribute("sessionUser");
            if(sessionUser == null){
                throw new RuntimeException("로그인이 필요합니다.");
            }

            reqDTO.setUserName(sessionUser.getUserName());
            reqDTO.setUserEmail(sessionUser.getUserEmail());

            System.out.println("updateReqDTO = " + reqDTO);
            userService.updatePassword(reqDTO);
            System.out.println("비밀번호 변경 성공!");
            return  "/user/loginForm";
        }catch (Exception e){
            return "비밀번호 변경 실패!" + e.getMessage();
        }

    }


}
