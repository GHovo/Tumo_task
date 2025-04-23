package configs.browser;

import configs.reader.ConfigurationReader;
import constants.base.BaseConstants;
import constants.base.BrowserTypes;

import static constants.base.BaseConstants.BROWSER;
import static constants.base.BaseConstants.CONFIG_PROPERTIES_PATH;

public class BrowserConfiguration extends ConfigurationReader {
    private static BrowserConfiguration INSTANCE;

    private BrowserConfiguration(String filePath) {
        super(filePath);
    }

    public static BrowserConfiguration getInstance() {
        if(INSTANCE == null){
            INSTANCE = new BrowserConfiguration(CONFIG_PROPERTIES_PATH);
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