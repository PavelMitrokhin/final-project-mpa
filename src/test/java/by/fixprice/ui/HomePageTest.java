package by.fixprice.ui;

import by.fixprice.ui.pages.home.HomePageExpectations;
import by.fixprice.ui.pages.home.HomePageSteps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HomePageTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger();

    @Test
    @DisplayName("Get selected Moskovskaya shop address text")
    void testGetSelectedShopAddressText() {
        Assertions.assertEquals("г.Брест, ул.Московская, д.202", new HomePageSteps().getSetupMoskovskayaAddressShop());
    }

    @Test
    @DisplayName("Compare selected shop address text to the list of addresses")
    void testCompareSelectedShopAddressTextToList() {
        List<String> expectedAddresses = HomePageExpectations.expectedBrestAddresses();
        String actualAddress = new HomePageSteps().getAnySelectedShopAddress();
        logger.info("Expected addresses: {}", expectedAddresses);
        logger.info("Actual address: {}", actualAddress);
        Assertions.assertTrue(expectedAddresses.contains(actualAddress));
    }
}
