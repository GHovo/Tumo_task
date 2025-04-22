package configs.reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class ConfigurationReader {
    protected final Properties properties;
    public ConfigurationReader(String filePath) {
        properties = new Properties();
        try (FileInputStream file = new FileInputStream(filePath)) {
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file: " + filePath, e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
