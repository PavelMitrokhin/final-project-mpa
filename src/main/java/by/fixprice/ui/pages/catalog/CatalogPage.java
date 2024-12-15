package by.fixprice.ui.pages.catalog;

import by.fixprice.ui.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage {
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger();


    public CatalogPage() {
        driver = Driver.getDriver();
    }

    public CatalogPage addFirstGoodFromChemicals() {
        logger.info("Adding first good from Chemicals");
        driver.findElement(By.xpath(CatalogPageXpath.BUTTON_ADD_FIRST_CHEMICAL_TO_CART_XPATH)).click();
        return this;
    }
}
