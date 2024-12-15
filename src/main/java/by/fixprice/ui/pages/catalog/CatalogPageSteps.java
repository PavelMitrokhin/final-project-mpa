package by.fixprice.ui.pages.catalog;

import by.fixprice.ui.pages.home.HomePage;

public class CatalogPageSteps {
    HomePage homePage = new HomePage();

    public String getCartBadgeCounterText() {
        homePage.openHouseholdChemicalsTab()
                .declineCookies()
                .addFirstGoodFromChemicals();
        homePage.closeForm();
        return homePage.getCartBadgeCounter();
    }
}
