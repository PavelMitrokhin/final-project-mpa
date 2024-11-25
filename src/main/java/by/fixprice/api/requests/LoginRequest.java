package by.fixprice.api.requests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;

public class LoginRequest {
    public static RequestSpecification requestSpecification;
    private static String numbers = "0123456789";
    private static String gmailDomain = "@gmail.com";

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

    public static String getBodyPasswordNull(String email, String phone) {
        return "{\n" +
                "    \"password\": null,\n" +
                "    \"email\": \"" + email + "\",\n" +
                "    \"phone\": \"" + phone + "\"\n" +
                "}";
    }

    public static String getBodyAllNulls() {
        return "{\n" +
                "    \"password\": null,\n" +
                "    \"email\": null,\n" +
                "    \"phone\": null\n" +
                "}";
    }
}
