package by.fixprice.ui;

import by.fixprice.ui.driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    public void setUpHomePage() {
        Driver.getDriver().get("https://fix-price.by/");
    }

    @AfterEach
    public void tearDownHomePage() {
        Driver.quit();
    }
}
