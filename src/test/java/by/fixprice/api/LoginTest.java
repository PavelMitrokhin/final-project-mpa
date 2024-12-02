package by.fixprice.api;

import by.fixprice.api.requests.LoginRequest;
import by.fixprice.api.responses.LoginResponse;
import by.fixprice.utils.api.ApiUsers;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.*;

import static org.hamcrest.Matchers.*;

public class LoginTest {

    @BeforeEach
    public void setUp() {
        LoginRequest.initRequestSpecification();
    }

    @Test
    @DisplayName("Null credentials: email, phone and password")
    public void nullCredentialsTest() {
        ValidatableResponse response = new LoginRequest().getResponseForRequestedData(new ApiUsers().getAllNullUser())
                .statusCode(400)
                .log().all()
                .body("message", equalTo(LoginResponse.ERROR_VALIDATION))
                .body("extra.phone[0]", equalTo(LoginResponse.ERROR_EMAIL_OR_PHONE_REQUIRED));
    }

    @Test
    @DisplayName("Empty (\"\") credentials: email, phone and password")
    public void emptyCredentialsTest() {
        ValidatableResponse response = new LoginRequest().getResponseForRequestedData(new ApiUsers().getAllEmptyUser())
                .statusCode(400)
                .log().all()
                .body("message", equalTo(LoginResponse.ERROR_VALIDATION))
                .body("extra.password[0]", equalTo(LoginResponse.ERROR_PASSWORD_REQUIRED));
    }

    @Test
    @DisplayName("Empty email and password")
    public void emptyEmailAndPasswordTest() {
        ValidatableResponse response = new LoginRequest().getResponseForRequestedData(new ApiUsers().getEmptyEmailAndPasswordUser())
                .statusCode(400)
                .log().all()
                .body("message", equalTo(LoginResponse.ERROR_VALIDATION))
                .body("extra.email[0]", equalTo(LoginResponse.ERROR_EMAIL_REQUIRED));
    }

    @Test
    @DisplayName("Empty phone and password")
    public void emptyPhoneAndPasswordTest() {
        ValidatableResponse response = new LoginRequest().getResponseForRequestedData(new ApiUsers().getEmptyPhoneAndPasswordUser())
                .statusCode(400)
                .log().all()
                .body("message", equalTo(LoginResponse.ERROR_VALIDATION))
                .body("extra.phone[0]", equalTo(LoginResponse.ERROR_PHONE_REQUIRED));
    }

    @Test
    @DisplayName("Empty password + valid phone")
    public void emptyPasswordAndValidPhoneTest() {
        ValidatableResponse response = new LoginRequest().getResponseForRequestedData(new ApiUsers().getPhoneWithoutPasswordUser())
                .statusCode(400)
                .log().all()
                .body("message", equalTo(LoginResponse.ERROR_VALIDATION))
                .body("extra.password[0]", equalTo(LoginResponse.ERROR_PASSWORD_REQUIRED));
    }

    @Test
    @DisplayName("Null password + valid email")
    public void validEmailAndNullPasswordTest() {
        ValidatableResponse response = new LoginRequest().getResponseForRequestedData(new ApiUsers().getEmailWithNullPasswordUser())
                .statusCode(400)
                .log().all()
                .body("message", equalTo(LoginResponse.ERROR_VALIDATION))
                .body("extra.password[0]", equalTo(LoginResponse.ERROR_PASSWORD_REQUIRED));
    }

    @Test
    @DisplayName("Incorrect email with password")
    public void incorrectEmailTest() {
        ValidatableResponse response = new LoginRequest().getResponseForRequestedData(new ApiUsers().getIncorrectEmailWithPasswordUser())
                .statusCode(400)
                .log().all()
                .body("message", equalTo(LoginResponse.ERROR_VALIDATION))
                .body("extra.email[0]", equalTo(LoginResponse.ERROR_ENTER_CORRECT_EMAIL));
    }

    @Test
    @DisplayName("Incorrect phone with password")
    public void incorrectPhoneTest() {
        ValidatableResponse response = new LoginRequest().getResponseForRequestedData(new ApiUsers().getIncorrectPhoneWithPasswordUser())
                .statusCode(400)
                .log().all()
                .body("message", equalTo(LoginResponse.ERROR_VALIDATION))
                .body("extra.phone[0]", equalTo(LoginResponse.ERROR_ENTER_CORRECT_PHONE));
    }

    @Test
    @DisplayName("Invalid phone or invalid password")
    public void invalidPhoneOrPasswordTest() {
        ValidatableResponse response = new LoginRequest().getResponseForRequestedData(new ApiUsers().getValidPhoneUser())
                .statusCode(400)
                .log().all()
                .body("message", containsString(LoginResponse.ERROR_INVALID_LOGIN_OR_PASSWORD));
    }

    @Test
    @DisplayName("Invalid email or invalid password")
    public void invalidEmailOrPasswordTest() {
        ValidatableResponse response = new LoginRequest().getResponseForRequestedData(new ApiUsers().getValidEmailUser())
                .statusCode(400)
                .log().all()
                .body("message", containsString(LoginResponse.ERROR_INVALID_LOGIN_OR_PASSWORD));
    }

    @Test
    @DisplayName("Email + phone + password")
    public void sendEmailAndPhoneAndPasswordTest() {
        ValidatableResponse response = new LoginRequest().getResponseForRequestedData(new ApiUsers().getPasswordEmailPhoneUser())
                .statusCode(400)
                .log().all()
                .body("message", containsString(LoginResponse.ERROR_INVALID_LOGIN_OR_PASSWORD));
    }

    @Test
    @DisplayName("No headers")
    public void noHeadersTest() {
        ValidatableResponse response = new LoginRequest().getResponseForRequestedDataNoHeaders()
                .statusCode(400)
                .log().all()
                .body("message", equalTo(LoginResponse.ERROR_FUNCTIONALITY_UNAVAILABLE));
    }

    @Test
    @DisplayName("No header x-key")
    public void noHeaderXKeyTest() {
       ValidatableResponse response = new LoginRequest().getResponseForRequestedDataNoXKeyHeader()
                .statusCode(400)
                .log().all()
                .body("message", equalTo(LoginResponse.ERROR_VALIDATION));
    }

    @Test
    @DisplayName("No header x-city")
    public void noHeaderXCityTest() {
        ValidatableResponse response = new LoginRequest().getResponseForRequestedDataNoXCityHeader()
                .statusCode(400)
                .log().all()
                .body("message", equalTo(LoginResponse.ERROR_FUNCTIONALITY_UNAVAILABLE));
    }

    @Test
    @DisplayName("No contentType")
    public void noHeaderContentTypeTest() {
        ValidatableResponse response = new LoginRequest().getResponseForRequestedDataNoContentType()
                .statusCode(400)
                .log().all()
                .body("message", equalTo(LoginResponse.ERROR_VALIDATION))
                .body("extra.phone[0]", equalTo(LoginResponse.ERROR_EMAIL_OR_PHONE_REQUIRED));
    }

    @Test
    @DisplayName("Too many requests")
    public void tooManyRequestsTest() {
        LoginRequest loginRequest = new LoginRequest();

        Assertions.assertTrue(loginRequest.hasTooManyRequests(new ApiUsers().getValidEmailUser()));
    }

    @Test
    @DisplayName(" more 5 tempts failed")
    public void sendFiveTriesTest() {
        LoginRequest loginRequest = new LoginRequest();

        Assertions.assertTrue(loginRequest.sendFiveTries(new ApiUsers().getValidPhoneUser()));
    }
}
