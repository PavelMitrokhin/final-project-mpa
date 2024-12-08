package by.fixprice.ui.pages.home.forms.login;

public class LoginFormXpath {
    public static final String BUTTON_PHONE_TAB_XPATH = "//*[@id=\"modal\"]/div/div/div[1]/button[1]";
    public static final String BUTTON_EMAIL_TAB_XPATH = "//*[@id=\"modal\"]/div/div/div[1]/button[2]";
    public static final String INPUT_LOGIN_XPATH = "//input[@class='input-text'][@type='text']";
    public static final String INPUT_PASSWORD_XPATH = "//*[@id=\"modal\"]/div/div/div[3]/div/input";
    public static final String CHECKBOX_AGREEMENT_XPATH = "//div[@class='checkbox-field']";
    public static final String BUTTON_ENTER_XPATH = "//button[@class='button enter-button normal']";
    public static final String BUTTON_REGISTER_XPATH = "//button[@class='button enter-button registration normal']";
    public static final String BUTTON_FORGOT_PASSWORD_XPATH = "//button[@class='forget-password-link']";
    public static final String BUTTON_BACK_TO_LOGIN_XPATH = "//button[@class='goto-login link']";
    public static final String BUTTON_CONTINUE_REGISTER_XPATH = "//button[@class='button button-send']";
    public static final String BUTTON_RESEND_CODE_XPATH = "//button[@data-test='resend']";
    public static final String BUTTON_CHANGE_PHONE_XPATH = "//button[@data-test='change-phone']";
    public static final String BUTTON_SMS_HELP_XPATH = "//button[@data-test='help']";
    public static final String BUTTON_GET_LINK_XPATH = "//button[@class='button get-link']";
    public static final String BUTTON_RESTORE_BY_PHONE_XPATH = "//button[@class='link'][contains(text(),'Восстановить по номеру телефона')]";

    public static final String INVALID_LOGIN_OR_PASSWORD_XPATH = "//div[@class='error']";
    public static final String CODE_IS_SENT_TITLE_XPATH = "//p[@class='phone-title'][contains(text(),'Сейчас Вам поступит СМС')]";
    public static final String SMS_HELP_TITLE_XPATH = "//div[@class='text'][contains(text(),'Не приходит СМС?')]";
    public static final String LOGIN_TITLE_XPATH = "//h1[@class='form-title']";

}
