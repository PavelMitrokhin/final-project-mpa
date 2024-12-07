package by.fixprice.ui.pages.home.forms.login;

import by.fixprice.ui.pages.home.HomePage;
import by.fixprice.utils.UiUsers;

public class LoginFormSteps {
    HomePage homePage = new HomePage();
    LoginForm loginForm = new LoginForm();
    UiUsers user = new UiUsers();

    public String checkInvalidPhoneUser() {
        homePage.openLoginForm().
                sendLogin(user.getPhoneAndPasswordUser()).
                sendPassword(user.getPhoneAndPasswordUser()).
                clickAgreementCheckbox().
                clickEnterLoginForm();
        return loginForm.getErrorInvalidLoginOrPassword();
    }

    public String checkInvalidEmailUser() {
        homePage.openLoginForm().
                selectEmailTab().
                sendLogin(user.getEmailAndPasswordUser()).
                sendPassword(user.getEmailAndPasswordUser()).
                clickAgreementCheckbox().
                clickEnterLoginForm();
        return loginForm.getErrorInvalidLoginOrPassword();
    }

    public String checkIncorrectEmailUser() {
        homePage.openLoginForm().
                selectEmailTab().
                sendLogin(user.getIncorrectEmailUser()).
                sendPassword(user.getIncorrectEmailUser()).
                clickAgreementCheckbox().
                clickEnterLoginForm();
        return loginForm.getErrorInvalidLoginOrPassword();
    }

    public String checkEmptyPassword() {
        homePage.openLoginForm().
                sendLogin(user.getPhoneAndPasswordUser()).
                clickAgreementCheckbox().
                clickEnterLoginForm();
        return loginForm.getErrorInvalidLoginOrPassword();
    }
}
