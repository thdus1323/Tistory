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
    public String join(@ModelAttribute UserRequest.JoinFormDTO reqDTO){
        userService.joinUser(reqDTO);
        System.out.println("reqDTO = " + reqDTO);
        return "/user/loginForm";
    }

    @GetMapping("/join-form")
    public String joinForm() {
        return "/user/joinForm";
    }

    @PostMapping("/login")
    public String login(UserRequest.LoginFormDTO reqDTO) {
        System.out.println("reqDTO = " + reqDTO);
        User sessionUser = userService.loginUser(reqDTO);
        session.setAttribute("sessionUser", sessionUser);
        return "redirect:/";
    }

    @GetMapping("login-form")
    public String loginForm() {
        return "/user/loginForm";
    }




}
