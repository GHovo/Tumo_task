package pages.header;

import api.languages.Language;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.header.forms.LanguageSwitcher;
import pages.login.LoginPage;

import static configs.driver.DriverManager.getDriver;
import static constants.header.HeaderConstants.*;

public class Header extends BasePage {
    private final LanguageSwitcher languageSwitcher;
    private final WebDriver driver;

    @FindBy(css = LOGO_LOCATOR)
    public WebElement logo;
    @FindBy(id = HELP_BUTTON_LOCATOR)
    public WebElement helpButton;
    @FindBy(className = LANGUAGE_BAR_LOCATOR)
    public WebElement languageBar;
    @FindBy(xpath = CHECKED_LANGUAGE_LOCATOR)
    public WebElement checkedLanguage;
    @FindBy(className = PROFILE_ICON_LOCATOR)
    public WebElement profileIcon;
    @FindBy(xpath = LOG_OUT_BUTTON_LOCATOR)
    public WebElement logOutButton;

    public Header(WebDriver driver, LanguageSwitcher languageSwitcher) {
        super(driver);
        this.languageSwitcher = languageSwitcher;
        this.driver = driver;
    }


    public String getCurrentLanguageTitle(){
        return checkedLanguage.getAttribute("class");
    }

    public WebElement getCheckedLanguage(Language desiredLanguage){
        return getDriver().findElement(By.xpath(
                String.format(LANGUAGE_LOCATOR, desiredLanguage.getTitleAttribute())));

    }

    public void switchLanguageTo(Language desiredLanguage) {
        String currentLanguage = getCurrentLanguageTitle();
        if (currentLanguage.contains(desiredLanguage.getTitleAttribute())) {
            return;
        }
        languageBar.click();
        wait.untilVisible(languageSwitcher.getLanguageByAttributeValue(desiredLanguage.getTitleAttribute()));
        languageSwitcher.clickToLanguage(desiredLanguage);
        wait.untilVisible(getCheckedLanguage(desiredLanguage));
    }
    public void logOut(){
        logOutButton.click();
        LoginPage loginPage = new LoginPage(driver);
        wait.untilVisible(loginPage.signIn);
    }
}
