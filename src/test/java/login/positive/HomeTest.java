package login.positive;

import base.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.header.Header;
import pages.header.forms.LanguageSwitcher;
import pages.login.LoginPage;

public class HomeTest extends BaseTest {

    private LanguageSwitcher languageSwitcher;

    @BeforeEach
    public void setup(){
        LoginPage loginPage = new LoginPage(driver);
        languageSwitcher = new LanguageSwitcher(driver);
        loginPage.login(user.email(),user.password());
    }


    @Test
    @DisplayName("Validate Header components")
    public void validateHeaderComponents(){

        Header header = new Header(driver, languageSwitcher);

        Assertions.assertThat(header.logo.isDisplayed())
                .isTrue();
        Assertions.assertThat(header.helpButton.isDisplayed())
                .isTrue();
        Assertions.assertThat(header.languageBar.isDisplayed())
                .isTrue();
        Assertions.assertThat(header.profileIcon.isDisplayed())
                .isTrue();
        Assertions.assertThat(header.logOutButton.isDisplayed())
                .isTrue();

    }

}
