package login;

import configs.browser.BrowserConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import static configs.driver.DriverManager.*;

public class BaseTest {
    protected WebDriver driver;
    private static final BrowserConfiguration browserConfig = BrowserConfiguration.getInstance();
    private static final String BASE_ULR = browserConfig.getBaseUrl();

    @BeforeEach
    public void setupDriver(){
        initDriver();
        driver = getDriver();
        openLoginPage();
    }

    private void openLoginPage(){
        driver.get(BASE_ULR);
    }

    @AfterEach
    public void closeDriver(){
        quitDriver();
    }
}
