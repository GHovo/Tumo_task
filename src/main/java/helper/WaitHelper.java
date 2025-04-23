package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {
    private static final int SHORT_TIMEOUT = 10;

    private static final int TIMEOUT = 30;

    private static final int LONG_TIMEOUT = 50;

    private final WebDriverWait wait;

    public WaitHelper(WebDriver driver, int timeoutInSeconds) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    public static WaitHelper shortWait(WebDriver driver) {
        return new WaitHelper(driver, SHORT_TIMEOUT);
    }

    public static WaitHelper defaultWait(WebDriver driver) {
        return new WaitHelper(driver, TIMEOUT);
    }

    public static WaitHelper longWait(WebDriver driver) {
        return new WaitHelper(driver, LONG_TIMEOUT);
    }

    public void untilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement untilVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void untilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void until(ExpectedCondition<?> condition) {
        wait.until(condition);
    }

}
