package pages.login;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.home.HomePage;

import static constants.login.LoginConstants.*;

public class LoginPage extends BasePage {
    private final WebDriver driver;
    @FindBy(css = TITLE_LOCATOR)
    public WebElement title;
    @FindBy(css = USER_NAME_INPUT_LOCATOR)
    public WebElement userNameInput;

    @FindBy(xpath = USER_NAME_HEADER_LOCATOR)
    public WebElement userNameHeader;
    @FindBy(css = PASSWORD_INPUT_LOCATOR)
    public WebElement passwordInput;

    @FindBy(xpath = PASSWORD_HEADER_LOCATOR)
    public WebElement passwordHeader;

    @FindBy(css = SIGN_IN_BUTTON_LOCATOR)
    public WebElement signIn;
    @FindBy(css = LOGIN_PAGE_IMG_LOCATOR)
    public WebElement loginImage;
    @FindBy(xpath = USER_NAME_REQUIRED_MESSAGE_LOCATOR)
    public WebElement usernameRequiredMessage;
    @FindBy(xpath = PASSWORD_REQUIRED_MESSAGE_LOCATOR)
    public WebElement passwordRequiredMessage;

    @FindBy(xpath = FORGOT_PASSWORD_BUTTON_LOCATOR)
    public WebElement forgotPasswordButton;


    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    @Step("Enter username: {userName}")
    public void enterUsername(final String userName) {
        userNameInput.sendKeys(userName);
    }
    @Step("Enter password: {password}")
    public void enterPassword(final String password) {
        passwordInput.sendKeys(password);
    }

    @Step("Get page title")
    public String getPageTitle(){
        return title.getText();
    }
    @Step("Get username input header text")
    public String getUserNameHeader(){
        return userNameHeader.getText();
    }
    @Step("Get password input header text")
    public String getPasswordHeader(){
        return passwordHeader.getText();
    }
    @Step("Get 'Sign In' button text")
    public String getSignInButtonText(){
        return signIn.getText();
    }

    @Step("Get 'Forgot Password' button text")
    public String getForgotPasswordText(){
        return forgotPasswordButton.getText();
    }
    @Step("Click 'Sign In' button")
    public void clickSignIn() {
        wait.untilClickable(signIn);
        signIn.click();
    }

    @Step("Click 'Forgot Password' button")
    public void clickForgotPassword() {
        wait.untilClickable(forgotPasswordButton);
        forgotPasswordButton.click();
    }

    @Step("Login with username: {userName} and password: {password}")
    public void login(final String userName, final String password) {
        enterUsername(userName);
        enterPassword(password);
        clickSignIn();
        HomePage homePage = new HomePage(driver);
        wait.untilVisible(homePage.onUserProfile().editProfile);
    }
    @Step("Fill in username: {userName} and password: {password} fields")
    public LoginPage fillUerNamePassword(final String userName, final String password) {
        enterUsername(userName);
        enterPassword(password);

        return this;
    }
}
