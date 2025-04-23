package configs.report.allure;

import io.qameta.allure.Attachment;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

@UtilityClass
public class AllureAttachments {
    @Attachment(value = "{name}", type = "image/png")
    public static byte[] saveScreenshot(WebDriver driver, @SuppressWarnings("unused") String name) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static void saveScreenshot(WebDriver driver) {
        saveScreenshot(driver, "Page screenshot");
    }
}
