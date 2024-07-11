package site.metacoding.blogv3.user;

import lombok.Data;

public class UserRequest {

    @Data
    public static class JoinDTO {
        private String userName;
        private String userPassword;
        private String userEmail;
        private String ConfirmPassword;
    }

    @Data
    public static class LoginDTO {
        private String userName;
        private String userPassword;
    }

    @Data
    public class ChangePasswordDTO {
        private String userName;
        private String userPassword;
        private String newPassword;
        private String userEmail;
    }
}
