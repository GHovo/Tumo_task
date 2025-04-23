package login.positive;

import base.BaseTest;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.home.HomePage;
import pages.home.forms.EditUserProfile;
import pages.home.forms.UserProfile;
import pages.login.LoginPage;

import static constants.base.BaseConstants.ARMENIA;

public class EditProfileTest extends BaseTest {

    private HomePage homePage;
    private EditUserProfile editUserProfile;

    @BeforeEach
    public void setup(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.email(), user.password());

        homePage = new HomePage(driver);
    }


    @Test
    @DisplayName("Validate Edit profile form components")
    public void validateEditProfileComponents(){
        homePage
                .onUserProfile()
                .tapOnEditProfileButton();

        editUserProfile = new EditUserProfile(driver);

        Assertions.assertThat(editUserProfile.title.isDisplayed())
                .isTrue();

        Assertions.assertThat(editUserProfile.addColorIcon.isDisplayed())
                .isTrue();

        Assertions.assertThat(editUserProfile.checkIcon.isDisplayed())
                .isTrue();


        Assertions.assertThat(editUserProfile.saveButton.isDisplayed())
                .isTrue();

        Assertions.assertThat(editUserProfile.cancelButton.isDisplayed())
                .isTrue();

    }

    @Test
    @DisplayName("Validate save editing functionality")
    public void validateSaveEditProfile(){
        homePage
                .onUserProfile()
                .tapOnEditProfileButton();

        editUserProfile = new EditUserProfile(driver);
        editUserProfile.editForArmenia(ARMENIA);
        UserProfile userProfile =  homePage.onUserProfile();
        String savedAboutMeText = userProfile.getAboutMeText();
        Assertions.assertThat(savedAboutMeText)
                .isEqualTo(ARMENIA);

        clearAboutMeFields();
    }

    @Test
    @DisplayName("Validate close Edit form")
    public void validateCloseEditProfile(){
        homePage
                .onUserProfile()
                .tapOnEditProfileButton();

        EditUserProfile editUserProfile = new EditUserProfile(driver);
        editUserProfile.closeEditForm();
        Assertions.assertThat(homePage.onUserProfile().editProfile.isDisplayed())
                .isTrue();
    }

    public void clearAboutMeFields(){
        homePage
                .onUserProfile()
                .tapOnEditProfileButton();

        editUserProfile = new EditUserProfile(driver);
        editUserProfile.clearAboutMeFields();
    }

}