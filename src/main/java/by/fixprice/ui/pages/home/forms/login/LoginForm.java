package by.fixprice.ui.pages.home.forms.login;

import by.fixprice.ui.driver.Driver;
import by.fixprice.utils.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginForm {
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger();

    public LoginForm() {
        driver = Driver.getDriver();
    }

    public LoginForm selectPhoneTab() {
        driver.findElement(By.xpath(LoginFormXpath.BUTTON_PHONE_TAB_XPATH)).click();
        return this;
    }

    public LoginForm selectEmailTab() {
        driver.findElement(By.xpath(LoginFormXpath.BUTTON_EMAIL_TAB_XPATH)).click();
        return this;
    }

    public LoginForm clickLoginField() {
        driver.findElement(By.xpath(LoginFormXpath.INPUT_LOGIN_XPATH)).click();
        return this;
    }

    public LoginForm sendLogin(User user) {
        logger.info("Login: {}", user.getLogin());
        driver.findElement(By.xpath(LoginFormXpath.INPUT_LOGIN_XPATH)).sendKeys(user.getLogin());
        return this;
    }

    public LoginForm sendPassword(User user) {
        logger.info("Password: {}", user.getPassword());
        driver.findElement(By.xpath(LoginFormXpath.INPUT_PASSWORD_XPATH)).sendKeys(user.getPassword());
        return this;
    }

    public LoginForm clickAgreementCheckbox() {
        driver.findElement(By.xpath(LoginFormXpath.CHECKBOX_AGREEMENT_XPATH)).click();
        return this;
    }

    public LoginForm clickEnterLoginForm() {
        driver.findElement(By.xpath(LoginFormXpath.BUTTON_ENTER_XPATH)).click();
        return this;
    }

    public String getErrorInvalidLoginOrPassword() {
        return driver.findElement(By.xpath(LoginFormXpath.INVALID_LOGIN_OR_PASSWORD_XPATH)).getText();
    }
}
