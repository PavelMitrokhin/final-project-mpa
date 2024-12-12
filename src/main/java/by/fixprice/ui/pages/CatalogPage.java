package by.fixprice.ui.pages;

import by.fixprice.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage {
    private WebDriver driver;

    public CatalogPage() {
        driver = Driver.getDriver();
    }

    public CatalogPage addFirstGood() {
        driver.findElement(By.xpath(CatalogPageXpath.BUTTON_ADD_FIRST_CHEMICAL_TO_CART_XPATH)).click();
        return this;
    }
}
