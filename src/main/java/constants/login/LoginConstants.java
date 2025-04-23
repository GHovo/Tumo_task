package constants.login;

public class LoginConstants {
    public static final String TITLE_LOCATOR = "h1[class='heading']";
    public static final String USER_NAME_INPUT_LOCATOR = "[type='text']";
    public static final String USER_NAME_HEADER_LOCATOR = "//input[@type='text']/preceding-sibling::label";
    public static final String PASSWORD_INPUT_LOCATOR = "[type='password']";
    public static final String PASSWORD_HEADER_LOCATOR = "//input[@type='password']/preceding-sibling::label";
    public static final String LOGIN_PAGE_IMG_LOCATOR = "[src='https://tumo-portfolio.pages.dev/assets/login-BzTApseU.png']";
    public static final String SIGN_IN_BUTTON_LOCATOR = "button[type='submit']";
    public static final String FORGOT_PASSWORD_BUTTON_LOCATOR = "//button[contains(@class,'recover-password')]";
    public static final String USER_NAME_REQUIRED_MESSAGE_LOCATOR = "(//div[@class='v-messages__message'])[1]";
    public static final String PASSWORD_REQUIRED_MESSAGE_LOCATOR = "(//div[@class='v-messages__message'])[2]";

}
