package pages.home.forms;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import static constants.home.alertnotification.AlertNotificationConstants.*;

public class AlertNotification extends BasePage {

    @FindBy(css = ALERT_NOTIFICATION_LOCATOR)
    public WebElement alertNotification;

    @FindBy(css = ALERT_NOTIFICATION_TITLE_LOCATOR)
    public WebElement alertNotificationTitle;

    @FindBy(css = ALERT_NOTIFICATION_TEXT_LOCATOR)
    public WebElement alertNotificationText;
    @FindBy(css = ALERT_NOTIFICATION_ICON_LOCATOR)
    public WebElement alertNotificationIcon;
    @FindBy(css = ALERT_CLOSE_BUTTON_LOCATOR)
    public WebElement alertCloseButton;

    public AlertNotification(WebDriver driver) {
        super(driver);
    }

    @Step("Get alert notification title")
    public String getAlertNotificationTitle(){
        wait.untilVisible(alertNotificationTitle);
       return alertNotificationTitle.getText();
    }
    @Step("Get alert notification text")
    public String getAlertNotificationText(){
        wait.untilVisible(alertNotificationText);
       return alertNotificationText.getText();
    }
}
