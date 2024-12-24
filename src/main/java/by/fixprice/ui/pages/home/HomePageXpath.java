package by.fixprice.ui.pages.home;

public class HomePageXpath {
    public static final String BUTTON_LOGIN_FORM_XPATH = "//button[@class='log-in link']";
    public static final String LINK_HOUSEHOLD_CHEMICALS_TAB_XPATH = "//a[@href='/catalog/bytovaya-khimiya'][@data-component]";
    public static final String BUTTON_SELECT_TOWN_XPATH = "//div[@class='locality']//div[@class='name']";
    public static final String INPUT_SEARCH_TOWN_XPATH = "/html/body/div/div/div/div/div[1]/div/div/div/div/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/input";
    public static final String SELECT_TARGET_TOWN_XPATH = "(//div[@class='locality'])[2]";
    public static final String SELECT_MOSKOVSKAYA_SHOP_XPATH = "//div[@class='address'][contains(text(),'г.Брест, ул.Московская, д.202')]";
    public static final String SELECT_RANDOM_SHOP_XPATH = "//div[@class='address']";
    public static final String BUTTON_CONFIRM_SHOP_XPATH = "//div[@class='select']";
    public static final String BUTTON_HEADER_SHOP_XPATH = "//div[@class='header-obtain-method']";
    public static final String OUTPUT_SHOP_ORDER_ADDRESS_XPATH = "//div[@class='row']//div[@class='title']";
    public static final String BUTTON_CLOSE_FORM_XPATH = "//button[@class='close'][@data-test='close-button']";
    public static final String BUTTON_CONFIRM_MY_TOWN_XPATH = "//*[@id=\"app-header\"]/header/div/div/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/button[1]";
}
