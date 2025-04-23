package configs.report.allure;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static configs.driver.DriverManager.getDriver;

public class WatcherExtension implements BeforeAllCallback, BeforeEachCallback, AfterTestExecutionCallback {
    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        StringBuilder sb = new StringBuilder().append("Stopping test ");
        boolean testFailed = extensionContext.getExecutionException().isPresent();
        if (testFailed) {
            sb.append("[FAILED]: ");
            if (!"true".equals(System.getProperty("checkTranslation"))) {
                AllureAttachments.saveScreenshot(getDriver());
            }
        }
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {

    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {

    }
}
