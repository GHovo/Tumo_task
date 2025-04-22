package configs.browser;

import configs.reader.ConfigurationReader;
import constants.BaseConstants;
import constants.BrowserTypes;

import static constants.BaseConstants.BROWSER;

public class BrowserConfiguration extends ConfigurationReader {
    private static BrowserConfiguration INSTANCE;

    private BrowserConfiguration(String filePath) {
        super(filePath);
    }

    public static BrowserConfiguration getInstance() {
        if(INSTANCE == null){
            INSTANCE = new BrowserConfiguration("src/main/resources/properties/config.properties");
        }
        return INSTANCE;
    }

    public BrowserTypes getBrowserType() {
        return BrowserTypes.parse(System.getProperty(BROWSER, BrowserTypes.CHROME.getType()));
    }

    public String getBaseUrl() {
        return getProperty(BaseConstants.BASE_URL_KEY);
    }
}