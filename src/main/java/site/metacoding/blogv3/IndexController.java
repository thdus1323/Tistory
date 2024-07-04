package site.metacoding.blogv3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "main";
    }

    //category view----------------------------------------------

    @GetMapping("ca-write-form")
    public String caWriteForm() {
        return "/category/writeForm";
    }


    //post view----------------------------------------------

    @GetMapping("detail")
    public String detail() {
        return "/post/detail";
    }

    @GetMapping("list")
    public String list() {
        return "/post/list";
    }

    @GetMapping("po-write-form")
    public String poWriteForm() {
        return "/post/writeForm";
    }



    //user view----------------------------------------------

    @GetMapping("join-form")
    public String joinForm() {
        return "/user/joinForm";
    }

    @GetMapping("login-form")
    public String loginForm() {
        return "/user/loginForm";
    }

    @GetMapping("password-reset-form")
    public String passwordResetForm() {
        return "/user/passwordResetForm";
    }

    @GetMapping("update-form")
    public String updateForm() {
        return "/user/updateForm";
    }









}
