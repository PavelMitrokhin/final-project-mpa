package by.fixprice.ui.pages.home;

public class HomePageSteps {
    HomePage homePage = new HomePage();

    public String getSetupMoskovskayaAddressShop() {
        homePage.clickHeaderShopAddress()
                .clickTownForDelivery()
                .sendTownForDelivery("Брест")
                .clickFoundTown()
                .clickMoskovskayaShop()
                .clickConfirmShop()
                .clickHeaderShopAddress();
        return homePage.getSelectedShopAddressText();
    }

    public String getAnySelectedShopAddress() {
        homePage.clickHeaderShopAddress()
                .clickTownForDelivery()
                .sendTownForDelivery("Брест")
                .clickFoundTown()
                .clickRandomAddress()
                .clickConfirmShop()
                .clickHeaderShopAddress();
        return homePage.getSelectedShopAddressText();
    }
}
