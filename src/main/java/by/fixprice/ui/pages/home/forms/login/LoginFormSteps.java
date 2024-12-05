package by.fixprice.ui.pages.home.forms.login;

import by.fixprice.ui.pages.home.HomePage;
import by.fixprice.utils.UiUsers;

public class LoginFormSteps {
    HomePage homePage = new HomePage();
    LoginForm loginForm = new LoginForm();

    public String checkInvalidPhoneUser() {
        UiUsers user = new UiUsers();
        homePage.openLoginForm();
        loginForm.
                sendLogin(user.getPhoneAndPasswordUser()).
                sendPassword(user.getPhoneAndPasswordUser()).
                clickAgreementCheckbox().
                clickEnterLoginForm();
        return loginForm.getErrorInvalidLoginOrPassword();
    }

    public String checkInvalidEmailUser() {
        UiUsers user = new UiUsers();
        homePage.openLoginForm();
        loginForm.
                selectEmailTab().
                sendLogin(user.getEmailAndPasswordUser()).
                sendPassword(user.getEmailAndPasswordUser()).
                clickAgreementCheckbox().
                clickEnterLoginForm();
        return loginForm.getErrorInvalidLoginOrPassword();
    }
}
