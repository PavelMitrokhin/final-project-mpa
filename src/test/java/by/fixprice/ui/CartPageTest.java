package by.fixprice.ui;

import by.fixprice.ui.pages.cart.CartPageSteps;
import by.fixprice.ui.pages.catalog.CatalogPageSteps;
import by.fixprice.ui.pages.home.HomePageSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CartPageTest extends BaseTest {
    @BeforeEach
    public void setUpCartPage() {
        new HomePageSteps().selectRandomAddress();
    }

    @Test
    @DisplayName("Test cart badge counter")
    void testCartBadgeCounter() {
        Assertions.assertEquals("1", new CatalogPageSteps().getCartBadgeCounterText());
    }

    @Test
    @DisplayName("Test total amount of goods in cart")
    void testTotalAmountOfGoodsInCart() {
        Assertions.assertEquals("1 шт.", new CartPageSteps().getTotalAmountOfGoods());
    }
}
