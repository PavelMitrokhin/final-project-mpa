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
        return faker.internet().password(8,20, true, true);
    }

    public static String generateBelarusMobilePhone(String countryCode) {
        int[] mobileCodesBelarus = {25, 29, 33, 44};
        int randomIndex = new Random().nextInt(mobileCodesBelarus.length);
        int mobileCodeBelarus = mobileCodesBelarus[randomIndex];
        return String.format(countryCode + mobileCodeBelarus + RandomStringUtils.randomNumeric(7));
    }

    public static String generateBelarusMobilePhone() {
        int[] mobileCodesBelarus = {25, 29, 33, 44};
        int randomIndex = new Random().nextInt(mobileCodesBelarus.length);
        int mobileCodeBelarus = mobileCodesBelarus[randomIndex];
        return String.format(mobileCodeBelarus + RandomStringUtils.randomNumeric(7));
    }

    public static String generateName() {
        return new Faker().name().firstName();
    }
}
