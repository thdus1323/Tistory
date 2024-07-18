package site.metacoding.blogv3.email;

import java.util.Random;

public class RandomNumberGenerator {

    public int generateRandomSixNumber(){
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }
}
