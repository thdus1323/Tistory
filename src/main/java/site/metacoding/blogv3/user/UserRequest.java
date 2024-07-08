package site.metacoding.blogv3.user;

import lombok.Data;

public class UserRequest {

    @Data
    public static class JoinFormDTO {
        public String userName;
        public String userPassword;
        public String userEmail;

//        public JoinFormDTO(String userName, String userPassword, String userEmail) {
//            this.userName = userName;
//            this.userPassword = userPassword;
//            this.userEmail = userEmail;
//        }
    }

    @Data
    public static class LoginFormDTO {
        public String userName;
        public String userPassword;
    }

}
