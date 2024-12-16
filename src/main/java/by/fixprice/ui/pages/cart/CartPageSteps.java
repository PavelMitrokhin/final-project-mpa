package by.fixprice.ui.pages.cart;

import by.fixprice.ui.pages.home.HomePage;

public class CartPageSteps {
    HomePage homePage = new HomePage();
    CartPage cartPage = new CartPage();

    public String getTotalAmountOfGoods() {
        homePage.openHouseholdChemicalsTab()
                .declineCookies()
                .addFirstGoodFromChemicals();
        homePage.closeForm()
                .clickCart();
        return cartPage.checkTotalAmountOfGoods();
    }
}
