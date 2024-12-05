package by.fixprice.ui;

import by.fixprice.ui.pages.home.forms.login.LoginFormExpectations;
import by.fixprice.ui.pages.home.forms.login.LoginFormSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginFormTest extends BaseTest {

    @Test
    @DisplayName("Invalid phone or password")
    void testInvalidPhoneOrPasswordUser() {
        Assertions.assertEquals(LoginFormExpectations.INVALID_LOGIN_OR_PASSWORD, new LoginFormSteps().checkInvalidPhoneUser());
    }

    @Test
    @DisplayName("Invalid email or password")
    void testInvalidEmailOrPasswordUser() {
        Assertions.assertEquals(LoginFormExpectations.INVALID_LOGIN_OR_PASSWORD, new LoginFormSteps().checkInvalidEmailUser());
    }

    @Test
    @DisplayName("Incorrect email")
    void testIncorrectEmail() {
        Assertions.assertEquals(LoginFormExpectations.INCORRECT_EMAIL_OR_PASSWORD,new LoginFormSteps().checkIncorrectEmailUser());
    }

    @Test
    @DisplayName("No password")
    void testNoPassword() {
        Assertions.assertEquals(LoginFormExpectations.PASSWORD_REQUIRED, new LoginFormSteps().checkEmptyPassword());
    }
}
