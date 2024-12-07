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

    public String getLoginTitle() {
        return driver.findElement(By.xpath(LoginFormXpath.LOGIN_TITLE_XPATH)).getText();
    }

    public LoginForm selectPhoneTab() {
        logger.info("Select phone tab");
        driver.findElement(By.xpath(LoginFormXpath.BUTTON_PHONE_TAB_XPATH)).click();
        return this;
    }

    public LoginForm selectEmailTab() {
        logger.info("Select email tab");
        driver.findElement(By.xpath(LoginFormXpath.BUTTON_EMAIL_TAB_XPATH)).click();
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
        logger.info("Click agreement checkbox");
        driver.findElement(By.xpath(LoginFormXpath.CHECKBOX_AGREEMENT_XPATH)).click();
        return this;
    }

    public LoginForm clickEnterLoginForm() {
        logger.info("Click \'Enter\'");
        driver.findElement(By.xpath(LoginFormXpath.BUTTON_ENTER_XPATH)).click();
        return this;
    }

    public String getErrorInvalidLoginOrPassword() {
        logger.info("Get error");
        return driver.findElement(By.xpath(LoginFormXpath.INVALID_LOGIN_OR_PASSWORD_XPATH)).getText();
    }

    public LoginForm clickRegisterButton() {
        logger.info("Click register button");
        driver.findElement(By.xpath(LoginFormXpath.BUTTON_REGISTER_XPATH)).click();
        return this;
    }

    public LoginForm clickContinueRegisterButton() {
        logger.info("Click continue register button");
        driver.findElement(By.xpath(LoginFormXpath.BUTTON_CONTINUE_REGISTER_XPATH)).click();
        return this;
    }

    public String getCodeSentTitle() {
        logger.info("Get 'send code' title");
        return driver.findElement(By.xpath(LoginFormXpath.CODE_IS_SENT_TITLE_XPATH)).getText();
    }

    public LoginForm changeRegisterPhone() {
        logger.info("Change register phone number");
        driver.findElement(By.xpath(LoginFormXpath.BUTTON_CHANGE_PHONE_XPATH)).click();
        return this;
    }

    public LoginForm resendCode() {
        logger.info("Resend code");
        driver.findElement(By.xpath(LoginFormXpath.BUTTON_RESEND_CODE_XPATH)).click();
        return this;
    }

    public LoginForm backToLogin() {
        logger.info("Back to login");
        driver.findElement(By.xpath(LoginFormXpath.BUTTON_BACK_TO_LOGIN_XPATH)).click();
        return this;
    }

    public LoginForm clickSmsHelp() {
        logger.info("SMS help");
        driver.findElement(By.xpath(LoginFormXpath.BUTTON_SMS_HELP_XPATH)).click();
        return this;
    }

    public String getSmsHelpTitle() {
        logger.info("Get sms help title");
        return driver.findElement(By.xpath(LoginFormXpath.SMS_HELP_TITLE_XPATH)).getText();
    }
}
