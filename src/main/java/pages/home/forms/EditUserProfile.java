package pages.home.forms;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.home.HomePage;

import static constants.home.edituserprofile.EditUserProfileConstants.*;
import static helper.ElementHelper.deleteInputText;

public class EditUserProfile extends BasePage {
    private final HomePage homePage;
    @FindBy(className = TITLE_LOCATOR)
    public WebElement title;
    @FindBy(id = ADD_COLOR_ICON_LOCATOR)
    public WebElement addColorIcon;
    @FindBy(xpath = CHECK_ICON_LOCATOR)
    public WebElement checkIcon;
    @FindBy(xpath = ARMENIA_TEXT_INPUT_AREA_LOCATOR)
    public WebElement armenianInputField;
    @FindBy(xpath = ENGLISH_TEXT_INPUT_AREA_LOCATOR)
    public WebElement englishInputField;
    @FindBy(xpath = SAVE_BUTTON_LOCATOR)
    public WebElement saveButton;
    @FindBy(xpath = CANSEL_BUTTON_LOCATOR)
    public WebElement cancelButton;
    @FindBy(xpath = CLOSE_BUTTON_LOCATOR)
    public WebElement closeButton;

    public EditUserProfile(WebDriver driver) {
        super(driver);
        this.homePage = new HomePage(driver);
    }
    @Step("Get title of the edit profile form")
    public String getPageTitle(){
        return title.getText();
    }
    @Step("Enter Armenian text: '{text}'")
    public void enterArmenianText(String text){
        armenianInputField.sendKeys(text);
    }
    @Step("Enter English text: '{text}'")
    public void enterEnglishText(String text){
        englishInputField.sendKeys(text);
    }
    @Step("Edit profile with Armenian: '{text}' and save changes")
    public void editForArmenia(String text){
        enterArmenianText(text);
        saveChanges();
        wait.untilVisible(homePage.onUserProfile().aboutMeText);
    }
    @Step("Edit profile with English: '{text}' and save changes")
    public void editForEnglish(String text){
        enterEnglishText(text);
        saveChanges();
    }
    @Step("Save changes in edit profile form")
    public void saveChanges(){
        saveButton.click();
        wait.untilVisible(homePage.onUserProfile().editProfile);
    }
    @Step("Cancel editing profile")
    public void cancelEditing(){
        cancelButton.click();
        wait.untilVisible(homePage.onUserProfile().editProfile);
    }
    @Step("Close edit profile form")
    public void closeEditForm(){
        closeButton.click();
        wait.untilVisible(homePage.onUserProfile().editProfile);
    }
    @Step("Clear 'About Me' fields and save")
    public void clearAboutMeFields(){
        deleteInputText(armenianInputField);
        deleteInputText(englishInputField);
        saveChanges();
    }
}
