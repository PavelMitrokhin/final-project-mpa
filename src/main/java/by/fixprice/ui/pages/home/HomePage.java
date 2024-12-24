package by.fixprice.ui.pages.home;

import by.fixprice.ui.driver.Driver;
import by.fixprice.ui.forms.login.LoginForm;
import by.fixprice.ui.pages.cart.CartPage;
import by.fixprice.ui.pages.catalog.CatalogPage;
import by.fixprice.ui.pages.catalog.CatalogPageXpath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

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

    public <T> T performActionOnElement(By locator, Function<WebElement, T> action) {
        logger.info("Performing action on element with locator: " + locator);
        int maxRetries = 2;
        for (int i = 0; i < maxRetries; i++) {
            logger.info("Attempt " + i + " to perform action on element");
            try {
                WebElement element = driver.findElement(locator);
                return action.apply(element);
            } catch (StaleElementReferenceException e) {
                if (i == maxRetries - 1) throw e;
            }
        }
        return null;
    }

    public CatalogPage openHouseholdChemicalsTab() {
        logger.info("Open household chemicals tab");
        return performActionOnElement(By.xpath(HomePageXpath.LINK_HOUSEHOLD_CHEMICALS_TAB_XPATH), webElement -> {
            webElement.click();
            return new CatalogPage();
        });
    }

    public HomePage clickHeaderShopAddress() {
        logger.info("Click header shop address");
        return performActionOnElement(By.xpath(HomePageXpath.BUTTON_HEADER_SHOP_XPATH), webElement -> {
            webElement.click();
            return this;
        });
    }

    public HomePage clickTownForDelivery() {
        logger.info("Click town for delivery");
        WebElement element = driver.findElement(By.xpath(HomePageXpath.BUTTON_SELECT_TOWN_XPATH));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        if (element.isDisplayed()) {
            element.click();
        } else {
            System.out.println("Element is not displayed");
        }
        return this;
    }

    public HomePage sendTownForDelivery(String town) {
        logger.info("Type to find town for delivery: " + town);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HomePageXpath.INPUT_SEARCH_TOWN_XPATH)));
        element.sendKeys(town);

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
        logger.info("Get selected shop address text: {}", driver.findElement(By.xpath(HomePageXpath.OUTPUT_SHOP_ORDER_ADDRESS_XPATH)).getText());
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
        logger.info("Get cart badge counter: {}", driver.findElement(By.xpath(CatalogPageXpath.CART_BADGE_COUNTER_XPATH)).getText());
        return driver.findElement(By.xpath(CatalogPageXpath.CART_BADGE_COUNTER_XPATH)).getText();
    }

    public HomePage clickRandomAddress() {
        logger.info("Select random address");
        List<WebElement> addresses = driver.findElements(By.xpath(HomePageXpath.SELECT_RANDOM_SHOP_XPATH));

        if (addresses.isEmpty()) {
            throw new IllegalStateException("No address selected");
        }

        int randomIndex = new Random().nextInt(addresses.size());
        WebElement selectRandomAddress = addresses.get(randomIndex);
        selectRandomAddress.click();
        logger.info("address: {}", selectRandomAddress.getText());

        return this;
    }

    public HomePage clickConfirmTown() {
        logger.info("Click confirm town");
        driver.findElement(By.xpath(HomePageXpath.BUTTON_CONFIRM_MY_TOWN_XPATH)).click();
        return this;
    }
}
