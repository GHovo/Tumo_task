package pages;

import helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected static WaitHelper wait;
    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait = WaitHelper.defaultWait(driver);
    }
}
