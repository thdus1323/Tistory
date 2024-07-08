package site.metacoding.blogv3.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
    private final HttpSession session;

    //회원가입
    @PostMapping("/join")
    public String join(@ModelAttribute UserRequest.JoinDTO reqDTO){
        userService.join(reqDTO);
        System.out.println("reqDTO = " + reqDTO);
        return "redirect:/loginForm";
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
        return "redirect:/";
    }

    @GetMapping("login-form")
    public String loginForm() {
        return "/user/loginForm";
    }

}
