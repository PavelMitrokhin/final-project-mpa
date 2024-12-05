package by.fixprice.ui;

import by.fixprice.ui.pages.home.HomePage;
import by.fixprice.ui.pages.home.forms.login.LoginForm;
import by.fixprice.ui.pages.home.forms.login.LoginFormExpectations;
import by.fixprice.utils.UiUsers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginFormTest extends BaseTest {
    HomePage homePage = new HomePage();
    LoginForm loginForm = new LoginForm();

    @Test
    @DisplayName("Invalid phone user")
    public void testInvalidPhoneUser() {
        UiUsers user = new UiUsers();
        homePage.openLoginForm();
        loginForm.
                sendLogin(user.getPhoneAndPasswordUser()).
                sendPassword(user.getPhoneAndPasswordUser()).
                clickAgreementCheckbox().
                clickEnterLoginForm();
        Assertions.assertEquals(LoginFormExpectations.LOGIN_FORM_TITLE, loginForm.getTitleLoginForm());
    }
}
