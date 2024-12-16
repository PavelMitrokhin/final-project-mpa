package by.fixprice.ui.pages.catalog;

import by.fixprice.ui.driver.Driver;
import by.fixprice.ui.pages.home.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class CatalogPage {
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger();


    public CatalogPage() {
        driver = Driver.getDriver();
    }

    public CatalogPage declineCookies() {
        logger.info("Declining cookies");
        return new HomePage().performActionOnElement(By.xpath(CatalogPageXpath.BUTTON_DECLINE_ALL_COOKIES_XPATH), webElement -> {
                    webElement.click();
                    return new CatalogPage();
                });
    }

    public CatalogPage addFirstGoodFromChemicals() {
        logger.info("Adding first good from Chemicals");
        driver.findElement(By.xpath(CatalogPageXpath.BUTTON_ADD_FIRST_CHEMICAL_TO_CART_XPATH)).click();
        return this;
    }

    public String getFirstChemicalGoodName() {
        logger.info("Getting first good name from Chemicals catalog: {}",
                driver.findElement(By.xpath(CatalogPageXpath.FIRST_CHEMICAL_GOOD_NAME_XPATH)).getText());
        return driver.findElement(By.xpath(CatalogPageXpath.FIRST_CHEMICAL_GOOD_NAME_XPATH)).getText();
    }
}
