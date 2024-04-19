package org.example.uzcarrd.util;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Setter
@Getter
public class RandomUtil {

    private static Random random=new Random();
    public static String getRandomSmsCode() {
        String parol = "123456789";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(parol.length());
            password.append(parol.charAt(index));
        }
        return password.toString();
    }

}
