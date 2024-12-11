package by.fixprice.ui.pages;

public class CatalogPageXpath {
    public static final String BUTTON_ADD_FIRST_CHEMICAL_TO_CART_XPATH = "(//button[@class='button button gridProduct'])[1]";
    public static final String BUTTON_SELECT_TOWN_XPATH = "//div[@class='locality']//div[@class='name']";
    public static final String INPUT_SEARCH_TOWN_XPATH = "(//input[@class='search-text'])[2]";
    public static final String SELECT_TARGET_TOWN_XPATH = "(//div[@class='locality'])[2]";
    public static final String SELECT_MOSKOVSKAYA_SHOP_XPATH = "//div[@class='address'][contains(text(),'г.Брест, ул.Московская, д.202')]";
    public static final String BUTTON_CONFIRM_SHOP_XPATH = "//div[@class='select']";
    public static final String BUTTON_HEADER_SHOP_XPATH = "//div[@class='header-obtain-method']";
    public static final String OUTPUT_SHOP_ORDER_ADDRESS_XPATH = "//div[@class='title'][contains(text(),'г.Брест, ул.Московская, д.202')]";
}
