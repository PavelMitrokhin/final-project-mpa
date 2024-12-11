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

    public CatalogPage clickTownForDelivery() {
        driver.findElement(By.xpath(CatalogPageXpath.BUTTON_SELECT_TOWN_XPATH)).click();
        return this;
    }

    public CatalogPage sendTownForDelivery(String town) {
        driver.findElement(By.xpath(CatalogPageXpath.INPUT_SEARCH_TOWN_XPATH)).sendKeys(town);
        return this;
    }

    public CatalogPage clickFoundTown() {
        driver.findElement(By.xpath(CatalogPageXpath.SELECT_TARGET_TOWN_XPATH)).click();
        return this;
    }

    public CatalogPage clickMoskovskayaShop() {
        driver.findElement(By.xpath(CatalogPageXpath.SELECT_MOSKOVSKAYA_SHOP_XPATH)).click();
        return this;
    }

    public CatalogPage clickConfirmShop() {
        driver.findElement(By.xpath(CatalogPageXpath.BUTTON_CONFIRM_SHOP_XPATH)).click();
        return this;
    }

    public CatalogPage clickHeaderOrderShopAddress() {
        driver.findElement(By.xpath(CatalogPageXpath.BUTTON_HEADER_SHOP_XPATH)).click();
        return this;
    }

    public String getOrderShopAddressText() {
        return driver.findElement(By.xpath(CatalogPageXpath.OUTPUT_SHOP_ORDER_ADDRESS_XPATH)).getText();
    }
}
