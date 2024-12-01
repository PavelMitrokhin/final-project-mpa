package by.fixprice.api.requests;

import by.fixprice.api.responses.LoginResponse;
import by.fixprice.utils.api.ApiUser;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class LoginRequest {
    public static RequestSpecification requestSpecification;
    public static String loginUrl = "https://api.fix-price.by/buyer/v2/auth/login";

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

    public ValidatableResponse getResponseForRequestedData(String password, String email, String phone) {
        ValidatableResponse response = given()
                .spec(LoginRequest.requestSpecification)
                .body("{\n" +
                        "    \"password\":" + password + ",\n" +
                        "    \"email\":" + email + ",\n" +
                        "    \"phone\":" + phone + "\n" +
                        "}")
                .when()
                .post()
                .then();
        return response;
    }

    public ValidatableResponse getResponseForRequestedData(ApiUser apiUser) {
        ValidatableResponse response = given()
                .spec(LoginRequest.requestSpecification)
                .body("{\n" +
                        "    \"password\":" + apiUser.getPassword() + ",\n" +
                        "    \"email\":" + apiUser.getEmail() + ",\n" +
                        "    \"phone\":" + apiUser.getPhone() + "\n" +
                        "}")
                .when()
                .post()
                .then();
        return response;
    }

    public ValidatableResponse getResponseForRequestedDataNoHeaders() {
        ValidatableResponse response = given()
                .body("{\n" +
                        "    \"password\": null,\n" +
                        "    \"email\": \"testemail@gmail.com\",\n" +
                        "    \"phone\": null\n" +
                        "}")
                .when()
                .post(loginUrl)
                .then();
        return response;
    }

    public ValidatableResponse getResponseForRequestedDataNoXKeyHeader() {
        ValidatableResponse response = given()
                .body("{\n" +
                        "    \"password\": null,\n" +
                        "    \"email\": \"testemail@gmail.com\",\n" +
                        "    \"phone\": \"+375299999999\"\n" +
                        "}")
                .header("x-city", "14")
                .contentType("application/json")
                .when()
                .post(loginUrl)
                .then();
        return response;
    }

    public ValidatableResponse getResponseForRequestedDataNoXCityHeader() {
        ValidatableResponse response = given()
                .body("{\n" +
                        "    \"password\": null,\n" +
                        "    \"email\": \"testemail@gmail.com\",\n" +
                        "    \"phone\": \"+375299999999\"\n" +
                        "}")
                .header("x-key", "740e56af4c394537d535819f54ba29cc")
                .contentType("application/json")
                .when()
                .post(loginUrl)
                .then();
        return response;
    }

    public ValidatableResponse getResponseForRequestedDataNoContentType(){
        ValidatableResponse response = given()
                .body("{\n" +
                        "    \"password\": null,\n" +
                        "    \"email\": \"testemail@gmail.com\",\n" +
                        "    \"phone\": \"+375299999999\"\n" +
                        "}")
                .headers(LoginRequest.getAllHeaders())
                .when()
                .post(loginUrl)
                .then();
        return response;
    }

    public boolean hasTooManyRequests(ApiUser user) {
        boolean hasTooManyRequestsResponse = false;

        while (!hasTooManyRequestsResponse) {
            Response response = given()
                    .spec(LoginRequest.requestSpecification)
                    .body("{\n" +
                            "    \"password\":" + user.getPassword() + ",\n" +
                            "    \"email\":" + user.getEmail() + ",\n" +
                            "    \"phone\":" + user.getPhone() + "\n" +
                            "}")
                    .when()
                    .post();

            if (response.statusCode() == 400) {
                String message = response.then().extract().path("message");
                if (message.equals(LoginResponse.ERROR_TOO_MANY_QUERIES)) {
                    hasTooManyRequestsResponse = true;
                }
            }
        }
        return hasTooManyRequestsResponse;
    }

    public boolean sendFiveTries(ApiUser user){
        boolean hasFiveRequestsResponse = false;

        for (int i = 1; i < 6; i++) {
            Response response = given()
                    .spec(LoginRequest.requestSpecification)
                    .body("{\n" +
                            "    \"password\":" + user.getPassword() + ",\n" +
                            "    \"email\":" + user.getEmail() + ",\n" +
                            "    \"phone\":" + user.getPhone() + "\n" +
                            "}")
                    .when()
                    .post();

            if (response.statusCode() == 400) {
                String message = response.then().extract().path("message");
                if (message.contains(LoginResponse.WARNING_LOGIN_LIMITS_EXCEEDED)) {
                    hasFiveRequestsResponse = true;
                }
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return hasFiveRequestsResponse;
    }
}
