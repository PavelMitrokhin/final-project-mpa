package by.fixprice.utils;

import com.github.javafaker.Faker;

import java.util.Random;

public class GenerationDataUtil {
    public static Faker faker = new Faker();

    public static String generateEmail(){
        return faker.internet().emailAddress();
    }

    public static String generatePassword(){
        return faker.internet().password();
    }

    public static String generateBelarusMobilePhone(){
        Random random = new Random();
        String countryCode = "+375";
        int[] mobileCodesBelarus = {25, 29, 33, 44};
        int mobileCodeBelarus = random.nextInt(mobileCodesBelarus.length);
        int number = 1000000 + random.nextInt(9000000);
        return String.format("%s-%s-%s", countryCode, mobileCodeBelarus, number);
    }
}
