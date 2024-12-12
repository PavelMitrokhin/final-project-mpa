package by.fixprice.ui.pages.home;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomePageSteps {
    HomePage homePage = new HomePage();
    private static final Logger logger = LogManager.getLogger();

    public String getSetupShopAddress() {
        homePage.clickHeaderShopAddress()
                .clickTownForDelivery()
                .sendTownForDelivery("Брест")
                .clickFoundTown()
                .clickMoskovskayaShop()
                .clickConfirmShop()
                .clickHeaderShopAddress();
        return homePage.getSelectedShopAddressText();
    }
}
