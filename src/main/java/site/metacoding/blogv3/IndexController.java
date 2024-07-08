package site.metacoding.blogv3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping({"/","/post/1"})
    public String index() {
        return "main";
    }

    //category view----------------------------------------------

    @GetMapping("/s/category/writeForm")
    public String caWriteForm() {
        return "/category/writeForm";
    }


    //post view----------------------------------------------

    @GetMapping("/s/user/1")
    public String detail() {
        return "/post/detail";
    }

    @GetMapping("/user/1/post")
    public String list() {
        return "/post/list";
    }

    @GetMapping("/s/post/write-form")
    public String poWriteForm() {
        return "/post/writeForm";
    }



    //user view----------------------------------------------




    @GetMapping("/logout")
    public String logout() {
        return "redirect:/user/loginForm";
    }


    @GetMapping("/user/password-reset-form")
    public String passwordResetForm() {
        return "/user/passwordResetForm";
    }

    @GetMapping("update-form")
    public String updateForm() {
        return "/user/updateForm";
    }











}
