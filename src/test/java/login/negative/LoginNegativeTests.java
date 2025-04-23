package login.negative;

import base.BaseTest;
import configs.reader.LocalizationReader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.home.forms.AlertNotification;
import pages.login.LoginPage;

public class LoginNegativeTests extends BaseTest {

    private LoginPage loginPage;
    private static String INCORRECT_CREDENTIALS_ALERT_TITLE;
    private static String INCORRECT_CREDENTIALS_ALERT_TEXT;

    @BeforeEach
    public void setup(){
        loginPage = new LoginPage(driver);
        LocalizationReader reader = new LocalizationReader("hy");
        INCORRECT_CREDENTIALS_ALERT_TITLE = reader.get("incorrectCredentialsAlertTitle");
        INCORRECT_CREDENTIALS_ALERT_TEXT = reader.get("incorrectCredentialsAlertAlertText");
    }


    @Test
    @DisplayName("Validate login with invalid credentials")
    public void shouldNotLoginWithInvalidCredentials() {

        loginPage
                .fillUerNamePassword("invalid user", "invalid password")
                .clickSignIn();


        AlertNotification alertNotification = new AlertNotification(driver);

        Assertions.assertThat(alertNotification.getAlertNotificationTitle())
                .isEqualTo(INCORRECT_CREDENTIALS_ALERT_TITLE);

        Assertions.assertThat(alertNotification.getAlertNotificationText())
                .isEqualTo(INCORRECT_CREDENTIALS_ALERT_TEXT);
    }

    @Test
    @DisplayName("Validate login with valid credentials plus spaces")
    public void shouldNotLoginWithWhitespaceCredentials() {
        loginPage
                .fillUerNamePassword(" " + user.email(), " " + user.password())
                .clickSignIn();

        AlertNotification alertNotification = new AlertNotification(driver);

        Assertions.assertThat(alertNotification.getAlertNotificationTitle())
                .isEqualTo(INCORRECT_CREDENTIALS_ALERT_TITLE);

        Assertions.assertThat(alertNotification.getAlertNotificationText())
                .isEqualTo(INCORRECT_CREDENTIALS_ALERT_TEXT);
    }

    @Test
    @DisplayName("Validate login with empty credentials")
    public void shouldNotLoginWithEmptyCredentials() {
        loginPage
                .fillUerNamePassword("", "")
                .clickSignIn();

        Assertions.assertThat(loginPage.usernameRequiredMessage.isDisplayed()).isTrue();
        Assertions.assertThat(loginPage.passwordRequiredMessage.isDisplayed()).isTrue();
    }

    @Test
    @DisplayName("Validate login without entering email")
    public void shouldNotLoginWithoutEmail() {
        loginPage
                .fillUerNamePassword("", "somePassword")
                .clickSignIn();

        Assertions.assertThat(loginPage.usernameRequiredMessage.isDisplayed()).isTrue();
    }

    @Test
    @DisplayName("Validate login without entering password")
    public void shouldNotLoginWithoutPassword() {
        loginPage
                .enterUsername("someEmail@example.com");

        loginPage
                .clickSignIn();

        Assertions.assertThat(loginPage.passwordRequiredMessage.isDisplayed()).isTrue();
    }


}

