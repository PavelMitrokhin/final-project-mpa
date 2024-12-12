package by.fixprice.ui;

import by.fixprice.ui.pages.home.HomePageSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HomePageTest extends BaseTest{

    @Test
    @DisplayName("Get selected shop address text")
    void testGetSelectedShopAddressText() {
        Assertions.assertEquals("г.Брест, ул.Московская, д.202", new HomePageSteps().getSetupShopAddress());
    }
}
