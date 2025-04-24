package login.positive;

import api.languages.Language;
import base.BaseTest;
import configs.reader.LocalizationReader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.forgotpassword.ForgotPassword;
import pages.header.Header;
import pages.header.forms.LanguageSwitcher;
import pages.home.HomePage;
import pages.login.LoginPage;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private LanguageSwitcher languageSwitcher;

    @BeforeEach
    public void setup(){
        loginPage = new LoginPage(driver);
        languageSwitcher = new LanguageSwitcher(driver);
    }

    @Test
    @DisplayName("Validate login with valid credentials")
    public void validateLoginWithValidCredentials(){
        loginPage.login(user.email(), user.password());
        HomePage homePage = new HomePage(driver);
        Assertions.assertThat(homePage.homePageScreen.isDisplayed())
                .isTrue();
    }

    @Test
    @DisplayName("Validate login with Armenian language")
    public void validateLoginWithArmenianLanguage(){
        Header header = new Header(driver, languageSwitcher);

        header.switchLanguageTo(Language.ARMENIAN);

        loginPage.login(user.email(), user.password());

        HomePage homePage = new HomePage(driver);
        LocalizationReader reader = new LocalizationReader("hy");
        String userNameOnArm = reader.get("profileName");
        Assertions.assertThat(homePage.onUserProfile().getUserName())
                .isEqualTo(userNameOnArm);
    }

    @Test
    @DisplayName("Validate login with English language")
    public void validateLoginWithEnglishLanguage(){
        Header header = new Header(driver, languageSwitcher);

        header.switchLanguageTo(Language.ENGLISH);

        loginPage.login(user.email(), user.password());

        HomePage homePage = new HomePage(driver);
        LocalizationReader reader = new LocalizationReader("en");
        String userNameOnEnglish = reader.get("profileName");
        Assertions.assertThat(homePage.onUserProfile().getUserName())
                .isEqualTo(userNameOnEnglish);
    }

    @Test
    @DisplayName("Validate login page components in Armenian")
    public void validateLoginComponentsInArmenian(){
        LocalizationReader reader = new LocalizationReader("hy");
        String welcome = reader.get("welcome.text");
        String userNameHeader = reader.get("userNameHeader");
        String passwordHeader = reader.get("passwordHeader");
        String signInText = reader.get("signIn");
        String forgotPasswordText = reader.get("forgotPassword");
        Header header = new Header(driver, languageSwitcher);

        header.switchLanguageTo(Language.ARMENIAN);

        Assertions.assertThat(loginPage.getPageTitle())
                .isEqualTo(welcome);
        Assertions.assertThat(loginPage.getUserNameHeader())
                .isEqualTo(userNameHeader);
        Assertions.assertThat(loginPage.getPasswordHeader())
                .isEqualTo(passwordHeader);
        Assertions.assertThat(loginPage.getSignInButtonText())
                .isEqualTo(signInText);
        Assertions.assertThat(loginPage.getForgotPasswordText())
                .isEqualTo(forgotPasswordText);
    }

    @Test
    @DisplayName("Validate login page components in English")
    public void validateLoginComponentsInEnglish(){
        LocalizationReader reader = new LocalizationReader("en");
        String welcome = reader.get("welcome.text");
        String userNameHeader = reader.get("userNameHeader");
        String passwordHeader = reader.get("passwordHeader");
        String signInText = reader.get("signIn");
        String forgotPasswordText = reader.get("forgotPassword");
        Header header = new Header(driver, languageSwitcher);

        header.switchLanguageTo(Language.ENGLISH);


        Assertions.assertThat(loginPage.getPageTitle())
                .isEqualTo(welcome);
        Assertions.assertThat(loginPage.getUserNameHeader())
                .isEqualTo(userNameHeader);
        Assertions.assertThat(loginPage.getPasswordHeader())
                .isEqualTo(passwordHeader);
        Assertions.assertThat(loginPage.getSignInButtonText())
                .isEqualTo(signInText);
        Assertions.assertThat(loginPage.getForgotPasswordText())
                .isEqualTo(forgotPasswordText);
    }

    @Test
    @DisplayName("Validate navigation to Forgot Password page")
    public void validateTapOnTheForgotPasswordNavigation(){
        LocalizationReader reader = new LocalizationReader("hy");
        String resetPasswordTitle = reader.get("resetPassword");
        loginPage.clickForgotPassword();
        ForgotPassword forgotPassword = new ForgotPassword(driver);

        Assertions.assertThat(forgotPassword.pageTitle.getText())
                .isEqualTo(resetPasswordTitle);
    }

    @Test
    @DisplayName("Validate change language functionality")
    public void validateChangeLanguageFunctionality(){
        Header header = new Header(driver, languageSwitcher);
        header.switchLanguageTo(Language.ENGLISH);

        Assertions.assertThat(header.getCheckedLanguage(Language.ENGLISH)
                .isDisplayed())
                .isTrue();

        header.switchLanguageTo(Language.ARMENIAN);
        Assertions.assertThat(header.getCheckedLanguage(Language.ARMENIAN)
                .isDisplayed())
                .isTrue();
        
    }

    @Test
    @DisplayName("Validate logout functionality")
    public void validateLogout(){
        Header header = new Header(driver, languageSwitcher);
        loginPage.login(user.email(), user.password());

        HomePage homePage = new HomePage(driver);
        Assertions.assertThat(homePage.homePageScreen.isDisplayed())
                .isTrue();

        header.logOut();

        Assertions.assertThat(loginPage.signIn.isDisplayed())
                .isTrue();
    }
}
