package by.fixprice.utils;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class GenerationDataUtil {
    public static Faker faker = new Faker();

    public static String generateEmail() {
        return faker.internet().emailAddress();
    }

    public static String generatePassword() {
        return faker.internet().password();
    }

    public static String generateBelarusMobilePhone() {
        Random random = new Random();
        String countryCode = "+375";
        int[] mobileCodesBelarus = {25, 29, 33, 44};
        int randomIndex = random.nextInt(mobileCodesBelarus.length);
        int mobileCodeBelarus = mobileCodesBelarus[randomIndex];
        return String.format(countryCode + mobileCodeBelarus + RandomStringUtils.randomNumeric(7));
    }

    public static String generateIncorrectLogin() {
        return RandomStringUtils.randomAscii(4, 14);
    }
}
