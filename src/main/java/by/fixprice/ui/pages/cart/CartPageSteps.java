package by.fixprice.ui.pages.cart;

import by.fixprice.ui.pages.catalog.CatalogPage;
import by.fixprice.ui.pages.home.HomePage;

public class CartPageSteps {
    HomePage homePage = new HomePage();
    CartPage cartPage = new CartPage();
    CatalogPage catalogPage = new CatalogPage();

    public String getTotalAmountOfGoods() {
        catalogPage.declineCookies();
        homePage.openHouseholdChemicalsTab()
                .addFirstGoodFromChemicals();
        homePage.closeForm()
                .clickCart();
        return cartPage.checkTotalAmountOfGoods();
    }

    public String getFirstAddedGoodNameInCart() {
        homePage.clickCart();
        return catalogPage.getFirstChemicalGoodName();
    }
}
