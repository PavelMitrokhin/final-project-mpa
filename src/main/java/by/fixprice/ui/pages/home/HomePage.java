package by.fixprice.ui.pages.home;

import by.fixprice.ui.driver.Driver;
import by.fixprice.ui.pages.home.forms.login.LoginForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage() {
        driver = Driver.getDriver();
    }

    public LoginForm openLoginForm() {
        driver.findElement(By.xpath(HomePageXpath.BUTTON_LOGIN_FORM_XPATH)).click();
        return new LoginForm();
    }
}
