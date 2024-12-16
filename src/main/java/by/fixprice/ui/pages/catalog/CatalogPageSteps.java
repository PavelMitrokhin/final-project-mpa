package by.fixprice.ui.pages.catalog;

import by.fixprice.ui.pages.home.HomePage;

public class CatalogPageSteps {
    HomePage homePage = new HomePage();
    CatalogPage catalogPage = new CatalogPage();

    public String getCartBadgeCounterText() {
        homePage.openHouseholdChemicalsTab()
                .declineCookies()
                .addFirstGoodFromChemicals();
        homePage.closeForm();
        return homePage.getCartBadgeCounter();
    }

    public String getFirstChemicalCatalog() {
        homePage.openHouseholdChemicalsTab()
                .declineCookies()
                .addFirstGoodFromChemicals();
        homePage.closeForm();
        return catalogPage.getFirstChemicalGoodName();
    }
}
