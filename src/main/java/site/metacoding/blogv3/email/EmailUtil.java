package site.metacoding.blogv3.email;




import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.mail.javamail.JavaMailSender;

@RequiredArgsConstructor
@Component
public class EmailUtil {

    private final JavaMailSender sender;

    public void sendEmail(String toAddresss, String subject, String body) {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(toAddresss);
            helper.setSubject(subject);
            helper.setText(body);
        }catch (MessagingException e) {
            throw new RuntimeException(e);
        }
            sender.send(message);
    }
}
