package by.fixprice.ui.pages.home.forms.login;

import by.fixprice.ui.driver.Driver;
import by.fixprice.utils.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginForm {
    private WebDriver driver;

    public LoginForm() {
        driver = Driver.getDriver();
    }

    public LoginForm(WebDriver driver) {
        this.driver = driver;
    }

    public LoginForm selectPhoneTab() {
        driver.findElement(By.xpath(LoginFormXpath.BUTTON_PHONE_TAB_XPATH)).click();
        return this;
    }

    public LoginForm selectEmailTab() {
        driver.findElement(By.xpath(LoginFormXpath.BUTTON_EMAIL_TAB_XPATH)).sendKeys();
        return this;
    }

    public LoginForm clickLoginField() {
        driver.findElement(By.xpath(LoginFormXpath.INPUT_LOGIN_XPATH)).click();
        return this;
    }

    public LoginForm sendLogin(User user) {
        driver.findElement(By.xpath(LoginFormXpath.INPUT_LOGIN_XPATH)).sendKeys(user.getLogin());
        return this;
    }

    public LoginForm sendPassword(User user) {
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

    public String getTitleLoginForm(){
        return driver.findElement(By.xpath(LoginFormXpath.LOGIN_FORM_TITLE_XPATH)).getText();
    }
}
