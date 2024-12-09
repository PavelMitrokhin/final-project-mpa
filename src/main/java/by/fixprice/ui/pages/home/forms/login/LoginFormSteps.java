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
                .sendPhone(user.getPhoneAndPasswordUser())
                .sendPassword(user.getPhoneAndPasswordUser())
                .clickAgreementCheckbox()
                .clickEnterLoginForm();
        return loginForm.getErrorInvalidLoginOrPassword();
    }

    public String checkInvalidEmailUser() {
        homePage.openLoginForm()
                .selectEmailTab()
                .sendEmail(user.getEmailAndPasswordUser())
                .sendPassword(user.getEmailAndPasswordUser())
                .clickAgreementCheckbox()
                .clickEnterLoginForm();
        return loginForm.getErrorInvalidLoginOrPassword();
    }

    public String checkIncorrectEmailUser() {
        homePage.openLoginForm()
                .selectEmailTab()
                .sendEmail(user.getIncorrectEmailUser())
                .sendPassword(user.getIncorrectEmailUser())
                .clickAgreementCheckbox()
                .clickEnterLoginForm();
        return loginForm.getErrorInvalidLoginOrPassword();
    }

    public String checkEmptyPassword() {
        homePage.openLoginForm()
                .sendPhone(user.getPhoneAndPasswordUser())
                .clickAgreementCheckbox()
                .clickEnterLoginForm();
        return loginForm.getErrorInvalidLoginOrPassword();
    }

    public String checkRegisterCodeSent() {
        homePage.openLoginForm()
                .clickRegisterButton()
                .sendPhone(user.getPhoneAndPasswordUser())
                .clickAgreementCheckbox()
                .clickContinueRegisterButton();
        return loginForm.getCodeSentTitle();
    }

    public String checkChangeRegisterPhone() {
        homePage.openLoginForm()
                .clickRegisterButton()
                .sendPhone(user.getPhoneAndPasswordUser())
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
                .sendPhone(user.getPhoneAndPasswordUser())
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
                .sendPhone(user.getPhoneAndPasswordUser())
                .clickAgreementCheckbox()
                .clickContinueRegisterButton()
                .clickSmsHelp();
        return loginForm.getSmsHelpTitle();
    }

    public String checkInvalidRestoreEmail() {
        homePage.openLoginForm()
                .clickForgotPassword()
                .sendRestoreEmail(user.getEmailAndPasswordUser())
                .clickGetLinkByEmail();
        return loginForm.getErrorInvalidLoginOrPassword();
    }

    public boolean hasFiveTriesToRestore() {
        boolean hasFiveRequestsResponse = false;
        homePage.openLoginForm()
                .clickForgotPassword()
                .sendRestoreEmail(user.getEmailAndPasswordUser());

        for (int i = 1; i < 6; i++) {
            logger.info("tempt #{}, email: {}, hasFiveRequestsResponse: {}",
                    i, user.getEmailAndPasswordUser().getLogin(), hasFiveRequestsResponse);
            String message = loginForm.clickGetLinkByEmail().getErrorInvalidLoginOrPassword();
            logger.info("message: {}", message);
            if (Objects.equals(message, LoginFormExpectations.INCORRECT_RESTORE_EMAIL_LIMIT)) {
                hasFiveRequestsResponse = true;
            }
        }

        logger.info("value \"hasFiveRequestsResponse\": {}", hasFiveRequestsResponse);
        return hasFiveRequestsResponse;
    }

    public String checkInvalidRestorePhone() {
        homePage.openLoginForm()
                .clickForgotPassword()
                .restoreByPhone()
                .sendPhone(user.getPhoneAndPasswordUser())
                .sendName()
                .clickGetLinkByPhone();
        return loginForm.getErrorInvalidLoginOrPassword();
    }

    public String checkTabInLogin() {
        homePage.openLoginForm()
                .selectEmailTab()
                .selectPhoneTab();
        return loginForm.getAttribute(LoginFormXpath.BUTTON_PHONE_TAB_XPATH, "class");
    }

    public String checkShowPassword() {
        homePage.openLoginForm()
                .clickShowPassword();
        return loginForm.getAttribute(LoginFormXpath.INPUT_PASSWORD_XPATH, "type");
    }
}
