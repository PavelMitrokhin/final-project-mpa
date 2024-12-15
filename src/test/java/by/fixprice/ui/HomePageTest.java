package by.fixprice.ui;

import by.fixprice.ui.pages.home.HomePageExpectations;
import by.fixprice.ui.pages.home.HomePageSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HomePageTest extends BaseTest {

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
        Assertions.assertTrue(expectedAddresses.contains(actualAddress));
    }
}
