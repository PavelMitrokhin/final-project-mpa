package by.fixprice.ui.pages.home.forms.login;

import by.fixprice.ui.pages.home.HomePage;
import by.fixprice.utils.UiUsers;

public class LoginFormSteps {
    HomePage homePage = new HomePage();
    LoginForm loginForm = new LoginForm();
    UiUsers user = new UiUsers();

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
}
