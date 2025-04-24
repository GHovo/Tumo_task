package pages.header.forms;

import api.languages.Language;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import static configs.driver.DriverManager.getDriver;
import static constants.header.languageswitcher.LanguageSwitcherConstants.LANGUAGE_LOCATOR;

public class LanguageSwitcher extends BasePage {

    public LanguageSwitcher(WebDriver driver) {
        super(driver);
    }

    @Step("Get language element by attribute value: {attributeValue}")
    public WebElement getLanguageByAttributeValue(String attributeValue){
        return getDriver().findElement(By.cssSelector(
                String.format(LANGUAGE_LOCATOR, attributeValue)));
    }

    @Step("Click on language: {desiredLanguage}")
    public void clickToLanguage(Language desiredLanguage){
        getLanguageByAttributeValue(desiredLanguage.getTitleAttribute()).click();
    }

}
