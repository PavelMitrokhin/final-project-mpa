package by.fixprice.ui;

import by.fixprice.ui.pages.home.forms.login.LoginFormExpectations;
import by.fixprice.ui.pages.home.forms.login.LoginFormSteps;
import dev.failsafe.internal.util.Assert;
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
        Assertions.assertEquals(LoginFormExpectations.INCORRECT_EMAIL_OR_PASSWORD, new LoginFormSteps().checkIncorrectEmailUser());
    }

    @Test
    @DisplayName("No password")
    void testNoPassword() {
        Assertions.assertEquals(LoginFormExpectations.PASSWORD_REQUIRED, new LoginFormSteps().checkEmptyPassword());
    }

    @Test
    @DisplayName("Register code sent")
    void testRegisterCodeSent() {
        Assertions.assertEquals(LoginFormExpectations.REGISTER_CODE_SENT, new LoginFormSteps().checkRegisterCodeSent());
    }

    @Test
    @DisplayName("Change register phone")
    void testChangeRegisterPhone() {
        Assertions.assertEquals(LoginFormExpectations.REGISTER_FORM_TEXT, new LoginFormSteps().checkChangeRegisterPhone());
    }

    @Test
    @DisplayName("No phone to register")
    void testNoPhoneToRegister() {
        Assertions.assertEquals(LoginFormExpectations.PHONE_NUMBER_IS_INVALID, new LoginFormSteps().noPhoneToRegister());
    }

    @Test
    @DisplayName("Check resend button state after click")
    void testCheckResendButtonStateAfterClick() {
        Assertions.assertTrue(!(new LoginFormSteps().checkCodeResend()));
    }

    @Test
    @DisplayName("Check return from register to login")
    void testCheckReturnFromRegisterToLogin() {
        Assertions.assertEquals(LoginFormExpectations.LOGIN_TITLE, new LoginFormSteps().backFromRegisterToLogin());
    }

    @Test
    @DisplayName("Check display of SMS help")
    void testCheckDisplayOfSMSHelp() {
        Assertions.assertEquals(LoginFormExpectations.SMS_HELP_TITLE, new LoginFormSteps().checkSmsHelpPopup());
    }

    @Test
    @DisplayName("Send incorrect email for restore")
    void testSendIncorrectEmailForRestore() {
        Assertions.assertEquals(LoginFormExpectations.INCORRECT_RESTORE_EMAIL, new LoginFormSteps().checkInvalidRestoreEmail());
    }

    @Test
    @DisplayName("Send incorrect email for restore 5 times")
    void testSendIncorrectEmailForRestoreFiveTimes() {
        Assert.isTrue(new LoginFormSteps().hasFiveTriesToRestore(), "No limit exceed message");
    }
}
