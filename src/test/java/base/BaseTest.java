package base;

import api.users.User;
import configs.browser.BrowserConfiguration;
import configs.env.EnvironmentLoader;
import configs.report.allure.WatcherExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static configs.driver.DriverManager.*;
@ExtendWith(WatcherExtension.class)
public class BaseTest {
    protected WebDriver driver;
    private static final BrowserConfiguration browserConfig = BrowserConfiguration.getInstance();
    private static final EnvironmentLoader environmentLoader = EnvironmentLoader.getInstance();
    private static final String BASE_ULR = browserConfig.getBaseUrl();
    protected static final User user = environmentLoader.getUser();

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
