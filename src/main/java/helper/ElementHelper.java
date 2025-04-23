package helper;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ElementHelper {
    public static void deleteInputText(WebElement element){
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
    }
}
