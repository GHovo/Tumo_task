package configs.driver;

import configs.browser.BrowserConfiguration;
import constants.BrowserTypes;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Optional;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static final BrowserConfiguration browserConfig = BrowserConfiguration.getInstance();

    private DriverManager(){}

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void initDriver(){
        if (driverThreadLocal.get() == null) {
            WebDriver driver = createDriver(browserConfig.getBrowserType());
            driverThreadLocal.set(driver);
            maximizeWindow(driver);
        }
    }

    private static WebDriver createDriver(BrowserTypes browserType) {
        return switch (browserType) {

            case CHROME -> getChromeDriver();

            case FIREFOX -> getFirefoxDriver();

            case IE ->  getEdgeDriver();

        };
    }

    private static EdgeDriver getEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    private static FirefoxDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }


    private static ChromeDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }


    public static void quitDriver() {
        Optional.ofNullable(driverThreadLocal.get()).ifPresent(driver -> {
            driver.quit();
            driverThreadLocal.remove();
        });
    }

    private static void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

}
