package by.fixprice.ui.pages.home;

import by.fixprice.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage() {
        driver = Driver.getDriver();
    }

    public HomePage openLoginForm() {
        driver.findElement(By.xpath(HomePageXpath.BUTTON_LOGIN_FORM_XPATH)).click();
        return this;
    }

    public HomePage selectPhoneTabLoginForm() {
        driver.findElement(By.xpath(HomePageXpath.BUTTON_PHONE_TAB_XPATH)).click();
        return this;
    }

    public HomePage selectEmailTabLoginForm() {
        driver.findElement(By.xpath(HomePageXpath.BUTTON_EMAIL_TAB_XPATH)).sendKeys();
        return this;
    }

    public HomePage sendEmailOrPhoneLoginForm() {
        driver.findElement(By.xpath(HomePageXpath.INPUT_PHONE_EMAIL_XPATH)).sendKeys();
        return this;
    }

    public HomePage sendPasswordLoginForm() {
        driver.findElement(By.xpath(HomePageXpath.INPUT_PASSWORD_XPATH)).sendKeys();
        return this;
    }

    public HomePage clickCheckboxLoginForm() {
        driver.findElement(By.xpath(HomePageXpath.CHECKBOX_AGREEMENT_XPATH)).click();
        return this;
    }

    public HomePage clickEnterLoginForm() {
        driver.findElement(By.xpath(HomePageXpath.BUTTON_ENTER_XPATH)).click();
        return this;
    }

    public String getTitleLoginForm(){
        return driver.findElement(By.xpath(HomePageXpath.LOGIN_FORM_TITLE_XPATH)).getText();
    }

}
