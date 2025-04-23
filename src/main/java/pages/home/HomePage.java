package pages.home;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.home.forms.UserProfile;

import static constants.home.HomeConstants.HOME_PAGE_SCREEN_LOCATOR;
import static constants.home.HomeConstants.USER_PROFILE_FORM_LOCATOR;

public class HomePage extends BasePage {

    private final UserProfile userProfile;

    @FindBy(id = HOME_PAGE_SCREEN_LOCATOR)
    public WebElement homePageScreen;
    @FindBy(className = USER_PROFILE_FORM_LOCATOR)
    public WebElement userProfileForm;
    public HomePage(WebDriver driver) {
        super(driver);
        userProfile = new UserProfile(driver);
    }

    @Step("Accessing User Profile form")
    public UserProfile onUserProfile(){
        return userProfile;
    }
}
