package by.fixprice.ui.pages;

import by.fixprice.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    public CartPage() {
        driver = Driver.getDriver();
    }

    public String checkTotalAmountOfGoods() {
        return driver.findElement(By.xpath(CartPageXpath.TOTAL_AMOUNT_OF_GOODS_XPATH)).getText();
    }
}
