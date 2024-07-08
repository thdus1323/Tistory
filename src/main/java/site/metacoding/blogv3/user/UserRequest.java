package site.metacoding.blogv3.user;

import lombok.Data;

public class UserRequest {

    @Data
    public static class JoinDTO {
        public String userName;
        public String userPassword;
        public String userEmail;
    }

    @Data
    public static class LoginDTO {
        public String userName;
        public String userPassword;
    }

}
