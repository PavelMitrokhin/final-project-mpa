package by.fixprice.api.requests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.devtools.v85.network.model.Request;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest {
    public static RequestSpecification requestSpecification;

    public static void initRequestSpecification() {
        requestSpecification = new RequestSpecBuilder()

                .setBaseUri("https://api.fix-price.by/")
                .setBasePath("/buyer/v2/auth/login")
                .setContentType("application/json")
                .addHeader("x-city", "14")
                .addHeader("x-key", "65bffe42769ff379b3a7a953e0561fb2")
                .build();
    }

    public static String getBody(String password, String email, String phone) {
        return "{\n" +
                "    \"password\": \"" + password + "\",\n" +
                "    \"email\": \"" + email + "\",\n" +
                "    \"phone\": \"" + phone + "\"\n" +
                "}";
    }

    public static String getBodyEmailNull(String password, String phone) {
        return "{\n" +
                "    \"password\": \"" + password + "\",\n" +
                "    \"email\": null,\n" +
                "    \"phone\": \"" + phone + "\"\n" +
                "}";
    }

    public static String getBodyPhoneNull(String password, String email) {
        return "{\n" +
                "    \"password\": \"" + password + "\",\n" +
                "    \"email\": \"" + email + "\",\n" +
                "    \"phone\": null\n" +
                "}";
    }

//    public static String getBodyPasswordNull(String password, String phone) {}

    public static String getBodyAllNulls() {
        return "{\n" +
                "    \"password\": null,\n" +
                "    \"email\": null,\n" +
                "    \"phone\": null\n" +
                "}";
    }



    private static String numbers = "0123456789";
    private static String gmailDomain = "@gmail.com";


    public static String getRandomEmail() {
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return RandomStringUtils.random(5, lowerCase)
                + RandomStringUtils.random(2, upperCase)
                + RandomStringUtils.random(3, numbers)
                + gmailDomain;
    }

    public static String getRandomPhone() {
        String phoneNumber = "+37529" + RandomStringUtils.randomNumeric(7);
        return phoneNumber;
    }
}
