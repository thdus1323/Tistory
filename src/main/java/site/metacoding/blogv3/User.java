package site.metacoding.blogv3;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_tb")
@NoArgsConstructor
@Data
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer userId;

    @Column(unique = true, length = 20, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private String userEmail;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public User(Integer userId, String userName, String userPassword, String userEmail, LocalDateTime createdAt) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.createdAt = createdAt;
    }
}
