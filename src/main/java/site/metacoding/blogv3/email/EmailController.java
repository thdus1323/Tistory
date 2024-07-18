package site.metacoding.blogv3.email;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EmailController {

    private final EmailUtil emailUtil;

    @GetMapping("/sendmail")
    public String sendMail() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int randomSixNumber = randomNumberGenerator.generateRandomSixNumber();

        String toAddress = "thdus1323@naver.com";
        String subject = "인증번호 테스트하지요!!!";
        String body = "되는지 테스트 중. 랜덤 번호 : " + randomSixNumber;

        emailUtil.sendEmail(toAddress, subject, body);

        return "Email sent successfully";
    }
}
