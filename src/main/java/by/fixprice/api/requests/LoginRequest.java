package by.fixprice.api.requests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest {
    public static RequestSpecification requestSpecification;

    public static Map<String, String> getAllHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("x-city", "14");
        headers.put("x-key", "65bffe42769ff379b3a7a953e0561fb2");
        return headers;
    }

    public static void initRequestSpecification() {
        requestSpecification = new RequestSpecBuilder()

                .setBaseUri("https://api.fix-price.by/")
                .setBasePath("/buyer/v2/auth/login")
                .setContentType("application/json")
                .addHeaders(getAllHeaders())
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
