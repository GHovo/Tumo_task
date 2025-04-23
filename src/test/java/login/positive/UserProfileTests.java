package login.positive;

import base.BaseTest;
import configs.reader.LocalizationReader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.home.HomePage;
import pages.home.forms.AlertNotification;
import pages.home.forms.EditUserProfile;
import pages.home.forms.UserProfile;
import pages.login.LoginPage;

public class UserProfileTests extends BaseTest {

    private LoginPage loginPage;

    @BeforeEach
    public void setup(){
        loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("Validate User profile form components")
    public void validateUserProfileComponents() {
        loginPage.login(user.email(), user.password());

        HomePage homePage = new HomePage(driver);
       UserProfile userProfile =  homePage.onUserProfile();
        Assertions.assertThat(userProfile.userName.isDisplayed())
                .isTrue();
        Assertions.assertThat(userProfile.userAvatar.isDisplayed())
                .isTrue();
        Assertions.assertThat(userProfile.sharePortfolio.isDisplayed())
                .isTrue();
        Assertions.assertThat(userProfile.editProfile.isDisplayed())
                .isTrue();
    }

    @Test
    @DisplayName("Validate share profile functionality")
    public void validateShareProfileFunctionality(){
        LocalizationReader reader = new LocalizationReader("hy");
        String copeLinkAlertTitle = reader.get("copeLinkAlertTitle");
        String copeLinkAlertText = reader.get("copeLinkAlertText");

        loginPage.login(user.email(), user.password());

        HomePage homePage = new HomePage(driver);
        homePage.onUserProfile().tapOnShareProfileButton();

        AlertNotification alertNotification = new AlertNotification(driver);

        Assertions.assertThat(alertNotification.alertNotification.isDisplayed())
                .isTrue();

        Assertions.assertThat(alertNotification.alertNotificationTitle.isDisplayed())
                .isTrue();


        Assertions.assertThat(alertNotification.alertNotificationText.isDisplayed())
                .isTrue();

        Assertions.assertThat(alertNotification.alertNotificationIcon.isDisplayed())
                .isTrue();

        Assertions.assertThat(alertNotification.alertCloseButton.isDisplayed())
                .isTrue();

        Assertions.assertThat(alertNotification.getAlertNotificationTitle())
                .isEqualTo(copeLinkAlertTitle);

        Assertions.assertThat(alertNotification.getAlertNotificationText())
                .isEqualTo(copeLinkAlertText);

    }
    @Test
    @DisplayName("Validate Edit window functionality")
    public void validateOpenEditWindowFunctionality(){
        LocalizationReader reader = new LocalizationReader("hy");
        String editProfileTitle = reader.get("editProfile");
        loginPage.login(user.email(), user.password());

        HomePage homePage = new HomePage(driver);
        homePage.onUserProfile().tapOnEditProfileButton();
        EditUserProfile editUserProfile = new EditUserProfile(driver);

        Assertions.assertThat(editUserProfile.getPageTitle())
                .isEqualTo(editProfileTitle);

    }

}
