package by.fixprice.api;

import by.fixprice.api.requests.LoginRequest;
import by.fixprice.api.responses.LoginResponse;
import by.fixprice.utils.ApiConstant;
import by.fixprice.utils.GenerationDataUtil;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class LoginTest {

    @BeforeEach
    public void setUp() {
        LoginRequest.initRequestSpecification();
    }

    @Test
    @DisplayName("Null credentials: email, phone and password")
    public void nullCredentialsTest() {
        given()
                .spec(LoginRequest.requestSpecification)
                .body(LoginRequest.getBodyAllNulls())
                .when()
                .post()
                .then()
                .statusCode(400)
                .log().all()
                .body("message", equalTo(LoginResponse.ERROR_VALIDATION))
                .body("extra.phone[0]", equalTo(LoginResponse.ERROR_EMAIL_OR_PHONE_REQUIRED));
    }

    @Test
    @DisplayName("Empty (\"\") credentials: email, phone and password")
    public void emptyCredentialsTest() {
        given()
                .spec(LoginRequest.requestSpecification)
                .body(LoginRequest.getBody("", "", ""))
                .when()
                .post()
                .then()
                .statusCode(400)
                .log().all()
                .body("message", equalTo(LoginResponse.ERROR_VALIDATION))
                .body("extra.password[0]", equalTo(LoginResponse.ERROR_PASSWORD_REQUIRED));
    }

    @Test
    @DisplayName("Empty email")
    public void emptyEmailTest() {
        given()
                .spec(LoginRequest.requestSpecification)
                .body(LoginRequest.getBodyPhoneNull("", ""))
                .when()
                .post()
                .then()
                .statusCode(400)
                .log().all()
                .body("message", equalTo(LoginResponse.ERROR_VALIDATION))
                .body("extra.email[0]", equalTo(LoginResponse.ERROR_EMAIL_REQUIRED));
    }

    @Test
    @DisplayName("Empty phone")
    public void emptyPhoneTest() {
        given()
                .spec(LoginRequest.requestSpecification)
                .body(LoginRequest.getBodyEmailNull("", ""))
                .when()
                .post()
                .then()
                .statusCode(400)
                .log().all()
                .body("message", equalTo(LoginResponse.ERROR_VALIDATION))
                .body("extra.phone[0]", equalTo(LoginResponse.ERROR_PHONE_REQUIRED));
    }

    @Test
    @DisplayName("Empty password + phone")
    public void emptyPasswordTest() {
        String randomPhone = GenerationDataUtil.generateBelarusMobilePhone();
        given()
                .spec(LoginRequest.requestSpecification)
                .body(LoginRequest.getBodyEmailNull("", randomPhone))
                .body("{\"password\":\"\",\"email\":null,\"phone\":\"" + randomPhone + "\"}")
                .when()
                .post()
                .then()
                .statusCode(400)
                .log().all()
                .body("message", equalTo(LoginResponse.ERROR_VALIDATION))
                .body("extra.password[0]", equalTo(LoginResponse.ERROR_PASSWORD_REQUIRED));
    }

    @Test
    @DisplayName("Email only (+ null password)")
    public void emailOnlyTest() {
        String randomEmail = GenerationDataUtil.generateEmail();
        String phone = null;
        given()
                .spec(LoginRequest.requestSpecification)
                .body(LoginRequest.getBodyPasswordNull(randomEmail, phone))
                .when()
                .post()
                .then()
                .statusCode(400)
                .log().all()
                .body("message", equalTo(LoginResponse.ERROR_VALIDATION))
                .body("extra.password[0]", equalTo(LoginResponse.ERROR_PASSWORD_REQUIRED));
    }

    @Test
    @DisplayName("Incorrect email")
    public void incorrectEmailTest() {
        String randomPassword = GenerationDataUtil.generatePassword();
        String incorrectEmail = GenerationDataUtil.generateIncorrectLogin();
        given()
                .spec(LoginRequest.requestSpecification)
                .body(LoginRequest.getBodyPhoneNull(randomPassword, incorrectEmail))
                .when()
                .post()
                .then()
                .statusCode(400)
                .log().all()
                .body("message", equalTo(LoginResponse.ERROR_VALIDATION))
                .body("extra.email[0]", equalTo(LoginResponse.ERROR_ENTER_CORRECT_EMAIL));
        ;
    }

    @Test
    @DisplayName("Incorrect phone")
    public void incorrectPhoneTest() {
        String randomPassword = GenerationDataUtil.generatePassword();
        String incorrectPhone = GenerationDataUtil.generateIncorrectLogin();
        given()
                .spec(LoginRequest.requestSpecification)
                .body(LoginRequest.getBodyEmailNull(randomPassword, incorrectPhone))
                .when()
                .post()
                .then()
                .statusCode(400)
                .log().all()
                .body("message", equalTo(LoginResponse.ERROR_VALIDATION))
                .body("extra.phone[0]", equalTo(LoginResponse.ERROR_ENTER_CORRECT_PHONE));
    }

    @Test
    @DisplayName("Invalid phone + invalid password")
    public void invalidPhoneAndPasswordTest() {
        String randomPassword = GenerationDataUtil.generatePassword();
        String randomPhone = GenerationDataUtil.generateBelarusMobilePhone();
        given()
                .spec(LoginRequest.requestSpecification)
                .body(LoginRequest.getBodyEmailNull(randomPassword, randomPhone))
                .when()
                .post()
                .then()
                .statusCode(400)
                .log().all()
                .body("message", containsString(LoginResponse.ERROR_INVALID_LOGIN_OR_PASSWORD));
    }

    @Test
    @DisplayName("Invalid email + invalid password")
    public void invalidEmailAndPasswordTest() {
        String randomPassword = GenerationDataUtil.generatePassword();
        String randomEmail = GenerationDataUtil.generateEmail();
        given()
                .spec(LoginRequest.requestSpecification)
                .body(LoginRequest.getBodyPhoneNull(randomPassword, randomEmail))
                .when()
                .post()
                .then()
                .statusCode(400)
                .log().all()
                .body("message", containsString(LoginResponse.ERROR_INVALID_LOGIN_OR_PASSWORD));
    }

    @Test
    @DisplayName("Email + phone + password")
    public void sendEmailAndPhoneAndPasswordTest() {
        String randomPassword = GenerationDataUtil.generatePassword();
        String randomEmail = GenerationDataUtil.generateEmail();
        String randomPhone = GenerationDataUtil.generateBelarusMobilePhone();
        given()
                .spec(LoginRequest.requestSpecification)
                .body(LoginRequest.getBody(randomPassword, randomEmail, randomPhone))
                .when()
                .post()
                .then()
                .statusCode(400)
                .log().all()
                .body("message", containsString(LoginResponse.ERROR_INVALID_LOGIN_OR_PASSWORD));
    }

    @Test
    @DisplayName("No headers")
    public void noHeadersTest() {
        String randomEmail = GenerationDataUtil.generateEmail();
        String phone = null;
        given()
                .body(LoginRequest.getBodyPasswordNull(randomEmail, phone))
                .when()
                .post(ApiConstant.LOGIN_URL)
                .then()
                .statusCode(400)
                .log().all()
                .body("message", equalTo(LoginResponse.ERROR_FUNCTIONALITY_UNAVAILABLE));
    }

    @Test
    @DisplayName("No header x-key")
    public void noHeaderXKeyTest() {
        String randomEmail = GenerationDataUtil.generateEmail();
        String phone = null;
        given()
                .body(LoginRequest.getBodyPasswordNull(randomEmail, phone))
                .header("x-city", "14")
                .contentType("application/json")
                .when()
                .post(ApiConstant.LOGIN_URL)
                .then()
                .statusCode(400)
                .log().all()
                .body("message", equalTo(LoginResponse.ERROR_VALIDATION));
    }

    @Test
    @DisplayName("No header x-city")
    public void noHeaderXCityTest() {
        String randomEmail = GenerationDataUtil.generateEmail();
        String phone = null;
        given()
                .body(LoginRequest.getBodyPasswordNull(randomEmail, phone))
                .header("x-key", "740e56af4c394537d535819f54ba29cc")
                .contentType("application/json")
                .when()
                .post(ApiConstant.LOGIN_URL)
                .then()
                .statusCode(400)
                .log().all()
                .body("message", equalTo(LoginResponse.ERROR_FUNCTIONALITY_UNAVAILABLE));
    }

    @Test
    @DisplayName("No header contentType")
    public void noHeaderContentTypeTest() {
        String email = GenerationDataUtil.generateEmail();
        String phone = GenerationDataUtil.generateBelarusMobilePhone();
        given()
                .body(LoginRequest.getBody("", email, phone))
                .headers(LoginRequest.getAllHeaders())
                .when()
                .post(ApiConstant.LOGIN_URL)
                .then()
                .statusCode(400)
                .log().all()
                .body("message", equalTo(LoginResponse.ERROR_VALIDATION))
                .body("extra.phone[0]", equalTo(LoginResponse.ERROR_EMAIL_OR_PHONE_REQUIRED));
    }

    @Test
    @DisplayName("Too many requests")
    public void tooManyRequestsTest() {
        boolean hasTooManyRequestsResponse = false;
        String randomPassword = GenerationDataUtil.generatePassword();
        String randomPhone = GenerationDataUtil.generateBelarusMobilePhone();

        while (!hasTooManyRequestsResponse) {
            Response response = given()
                    .spec(LoginRequest.requestSpecification)
                    .body(LoginRequest.getBodyEmailNull(randomPassword, randomPhone))
                    .when()
                    .post();

            if (response.statusCode() == 400) {
                String message = response.then().extract().path("message");
                if (message.equals("Слишком много запросов")) {
                    hasTooManyRequestsResponse = true;
                }
            }
        }

        Assertions.assertTrue(hasTooManyRequestsResponse);
    }

    @Test
    @DisplayName(" more 5 tempts failed")
    public void sendFiveTriesTest() {
        boolean hasFiveRequestsResponse = false;
        String randomPassword = GenerationDataUtil.generatePassword();
        String randomEmail = GenerationDataUtil.generateEmail();

        for (int i = 1; i < 6; i++) {
            Response response = given()
                    .spec(LoginRequest.requestSpecification)
                    .body(LoginRequest.getBodyPhoneNull(randomPassword, randomEmail))
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

        Assertions.assertTrue(hasFiveRequestsResponse);
    }
}
