package by.fixprice.ui.pages.home.forms.login;

import by.fixprice.ui.pages.home.HomePage;
import by.fixprice.utils.UiUsers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

import static io.restassured.RestAssured.given;

public class LoginFormSteps {
    HomePage homePage = new HomePage();
    LoginForm loginForm = new LoginForm();
    UiUsers user = new UiUsers();
    private static final Logger logger = LogManager.getLogger();

    public String checkInvalidPhoneUser() {
        homePage.openLoginForm()
                .sendLogin(user.getPhoneAndPasswordUser())
                .sendPassword(user.getPhoneAndPasswordUser())
                .clickAgreementCheckbox()
                .clickEnterLoginForm();
        return loginForm.getErrorInvalidLoginOrPassword();
    }

    public String checkInvalidEmailUser() {
        homePage.openLoginForm()
                .selectEmailTab()
                .sendLogin(user.getEmailAndPasswordUser())
                .sendPassword(user.getEmailAndPasswordUser())
                .clickAgreementCheckbox()
                .clickEnterLoginForm();
        return loginForm.getErrorInvalidLoginOrPassword();
    }

    public String checkIncorrectEmailUser() {
        homePage.openLoginForm()
                .selectEmailTab()
                .sendLogin(user.getIncorrectEmailUser())
                .sendPassword(user.getIncorrectEmailUser())
                .clickAgreementCheckbox()
                .clickEnterLoginForm();
        return loginForm.getErrorInvalidLoginOrPassword();
    }

    public String checkEmptyPassword() {
        homePage.openLoginForm()
                .sendLogin(user.getPhoneAndPasswordUser())
                .clickAgreementCheckbox()
                .clickEnterLoginForm();
        return loginForm.getErrorInvalidLoginOrPassword();
    }

    public String checkRegisterCodeSent() {
        homePage.openLoginForm()
                .clickRegisterButton()
                .sendLogin(user.getPhoneAndPasswordUser())
                .clickAgreementCheckbox()
                .clickContinueRegisterButton();
        return loginForm.getCodeSentTitle();
    }

    public String checkChangeRegisterPhone() {
        homePage.openLoginForm()
                .clickRegisterButton()
                .sendLogin(user.getPhoneAndPasswordUser())
                .clickAgreementCheckbox()
                .clickContinueRegisterButton()
                .changeRegisterPhone();
        return loginForm.getRegisterFormText();
    }

    public String noPhoneToRegister() {
        homePage.openLoginForm()
                .clickRegisterButton()
                .clickAgreementCheckbox()
                .clickContinueRegisterButton();
        return loginForm.getErrorInvalidLoginOrPassword();
    }

    public boolean checkCodeResend() {
        homePage.openLoginForm()
                .clickRegisterButton()
                .sendLogin(user.getPhoneAndPasswordUser())
                .clickAgreementCheckbox()
                .clickContinueRegisterButton()
                .resendCode();
        return loginForm.isElementEnabled(LoginFormXpath.BUTTON_RESEND_CODE_XPATH);
    }

    public String backFromRegisterToLogin() {
        homePage.openLoginForm()
                .clickRegisterButton()
                .backToLogin();
        return loginForm.getLoginTitle();
    }

    public String checkSmsHelpPopup() {
        homePage.openLoginForm()
                .clickRegisterButton()
                .sendLogin(user.getPhoneAndPasswordUser())
                .clickAgreementCheckbox()
                .clickContinueRegisterButton()
                .clickSmsHelp();
        return loginForm.getSmsHelpTitle();
    }

    public String checkInCorrectRestoreEmail() {
        homePage.openLoginForm()
                .clickForgotPassword()
                .sendLogin(user.getEmailAndPasswordUser())
                .clickGetLink();
        return loginForm.getErrorInvalidLoginOrPassword();
    }

    public boolean hasFiveTriesToRestore() {
        boolean hasFiveRequestsResponse = false;
        homePage.openLoginForm()
                .clickForgotPassword()
                .sendLogin(user.getEmailAndPasswordUser());

        for (int i = 1; i < 6; i++) {
            logger.info("tempt #{}, email: {}, hasFiveRequestsResponse: {}",
                    i, user.getEmailAndPasswordUser().getLogin(), hasFiveRequestsResponse);
            String message = loginForm.clickGetLink().getErrorInvalidLoginOrPassword();
            logger.info("message: {}", message);
            if (Objects.equals(message, LoginFormExpectations.INCORRECT_RESTORE_EMAIL_LIMIT)) {
                hasFiveRequestsResponse = true;
            }
        }

        logger.info("value \"hasFiveRequestsResponse\": {}", hasFiveRequestsResponse);
        return hasFiveRequestsResponse;
    }
}
