package pages.forgotpassword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import static constants.forgotpassword.ForgotPasswordConstants.TITLE_LOCATOR;

public class ForgotPassword extends BasePage {
    @FindBy(className = TITLE_LOCATOR)
    public WebElement pageTitle;
    public ForgotPassword(WebDriver driver) {
        super(driver);
    }
}
