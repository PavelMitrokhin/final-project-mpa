package by.fixprice.ui;

import by.fixprice.ui.pages.home.forms.login.LoginFormExpectations;
import by.fixprice.ui.pages.home.forms.login.LoginFormSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginFormTest extends BaseTest {

    @Test
    @DisplayName("Invalid phone user")
    public void testInvalidPhoneUser() {
        Assertions.assertEquals(LoginFormExpectations.LOGIN_FORM_TITLE, new LoginFormSteps().checkInvalidPhoneUser());
    }
}
