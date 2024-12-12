package by.fixprice.ui.pages.home;

import by.fixprice.ui.driver.Driver;
import by.fixprice.ui.forms.login.LoginForm;
import by.fixprice.ui.pages.CartPage;
import by.fixprice.ui.pages.CatalogPage;
import by.fixprice.ui.pages.CatalogPageXpath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class HomePage {
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger();

    public HomePage() {
        driver = Driver.getDriver();
    }

    public LoginForm openLoginForm() {
        logger.info("Open login form");
        driver.findElement(By.xpath(HomePageXpath.BUTTON_LOGIN_FORM_XPATH)).click();
        return new LoginForm();
    }

    public CatalogPage openHouseholdChemicalsTab() {
        logger.info("Open household chemicals tab");
        driver.findElement(By.xpath(HomePageXpath.LINK_HOUSEHOLD_CHEMICALS_TAB_XPATH)).click();
        return new CatalogPage();
    }

    public HomePage clickHeaderShopAddress() {
        logger.info("Click header shop address");
        int maxRetries = 2;
        for (int i = 0; i < maxRetries; i++) {
            logger.info("Trying to click header shop address " + i);
            try {
                driver.findElement(By.xpath(HomePageXpath.BUTTON_HEADER_SHOP_XPATH)).click();
                break;
            } catch (StaleElementReferenceException e) {
                if (i == maxRetries - 1) throw e;
            }
        }
        return this;
    }

    public HomePage clickTownForDelivery() {
        logger.info("Click town for delivery");
        driver.findElement(By.xpath(HomePageXpath.BUTTON_SELECT_TOWN_XPATH)).click();
        return this;
    }

    public HomePage sendTownForDelivery(String town) {
        logger.info("Type to find town for delivery: " + town);
        driver.findElement(By.xpath(HomePageXpath.INPUT_SEARCH_TOWN_XPATH)).sendKeys(town);
        return this;
    }

    public HomePage clickFoundTown() {
        logger.info("Click found town");
        driver.findElement(By.xpath(HomePageXpath.SELECT_TARGET_TOWN_XPATH)).click();
        return this;
    }

    public HomePage clickMoskovskayaShop() {
        logger.info("Click Moskovskaya street shop");
        driver.findElement(By.xpath(HomePageXpath.SELECT_MOSKOVSKAYA_SHOP_XPATH)).click();
        return this;
    }

    public HomePage clickConfirmShop() {
        logger.info("Click confirm selected shop");
        driver.findElement(By.xpath(HomePageXpath.BUTTON_CONFIRM_SHOP_XPATH)).click();
        return this;
    }

    public String getSelectedShopAddressText() {
        logger.info("Get selected shop address text");
        return driver.findElement(By.xpath(HomePageXpath.OUTPUT_SHOP_ORDER_ADDRESS_XPATH)).getText();
    }

    public HomePage closeForm() {
        logger.info("Close form");
        driver.findElement(By.xpath(HomePageXpath.BUTTON_CLOSE_FORM_XPATH)).click();
        return this;
    }

    public CartPage clickCart() {
        logger.info("Click cart");
        driver.findElement(By.xpath(CatalogPageXpath.LINK_CART_XPATH)).click();
        return new CartPage();
    }

    public String getCartBadgeCounter() {
        logger.info("Get cart badge counter");
        return driver.findElement(By.xpath(CatalogPageXpath.CART_BADGE_COUNTER_XPATH)).getText();
    }

    public HomePage clickRandomAddress() {
        logger.info("Select random address");
        List<WebElement> addresses = driver.findElements(By.xpath(HomePageXpath.SELECT_RANDOM_SHOP_XPATH));

        if (addresses.isEmpty()){
            throw new IllegalStateException("No address selected");
        }

        int randomIndex = new Random().nextInt(addresses.size());
        WebElement selectRandomAddress = addresses.get(randomIndex);
        selectRandomAddress.click();
        logger.info("address {}", selectRandomAddress.getText());

        return this;
    }
}
