package pages.home.forms;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import static constants.home.userprofile.UserProfileConstants.*;

public class UserProfile extends BasePage {
    private final WebDriver driver;
    @FindBy(id = USER_AVATAR_LOCATOR)
    public WebElement userAvatar;
    @FindBy(css = USER_NAME_LOCATOR)
    public WebElement userName;
    @FindBy(id = SHARE_PORTFOLIO_BUTTON_LOCATOR)
    public WebElement sharePortfolio;
    @FindBy(id = EDIT_PORTFOLIO_BUTTON_LOCATOR)
    public WebElement editProfile;
    @FindBy(className = ABOUT_ME_TEXT_LOCATOR)
    public WebElement aboutMeText;
    public UserProfile(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Get user name from profile")
    public String getUserName(){
        return userName.getText();
    }
    @Step("Get 'About Me' text from profile")
    public String getAboutMeText(){
        return aboutMeText.getText();
    }
    @Step("Tap on 'Edit Profile' button")
    public void tapOnEditProfileButton(){
        EditUserProfile editUserProfile = new EditUserProfile(driver);
        wait.untilClickable(editProfile);
        editProfile.click();
        wait.untilVisible(editUserProfile.saveButton);
    }
    @Step("Tap on 'Share Portfolio' button")
    public void tapOnShareProfileButton(){
        wait.untilVisible(sharePortfolio);
        sharePortfolio.click();
        AlertNotification alertNotification = new AlertNotification(driver);
        wait.untilVisible(alertNotification.alertNotification);
    }
}
