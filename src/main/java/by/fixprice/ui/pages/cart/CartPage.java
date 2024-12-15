package by.fixprice.ui.pages.cart;

import by.fixprice.ui.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger();

    public CartPage() {
        driver = Driver.getDriver();
    }

    public String checkTotalAmountOfGoods() {
        logger.info("Checking total amount of goods: {}", driver.findElement(By.xpath(CartPageXpath.TOTAL_AMOUNT_OF_GOODS_XPATH)).getText());
        return driver.findElement(By.xpath(CartPageXpath.TOTAL_AMOUNT_OF_GOODS_XPATH)).getText();
    }
}
