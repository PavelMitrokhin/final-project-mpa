package by.fixprice.ui;

import by.fixprice.ui.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

public class BaseTest {
    private static final Logger logger = LogManager.getLogger();

    @BeforeEach
    public void setUpHomePage(TestInfo testInfo) {
        logger.info(testInfo.getDisplayName());
        Driver.getDriver().get("https://fix-price.by/");
    }

    @AfterEach
    public void tearDownHomePage() {
        Driver.quit();
    }
}
