package site.metacoding.blogv3;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/join")
    public String join(@RequestBody UserRequest.JoinFormDTO reqDTO){
        userService.joinUser(reqDTO);
        System.out.println("userName = " + reqDTO.getUserName());
        return "redirect:/";
    }

}
