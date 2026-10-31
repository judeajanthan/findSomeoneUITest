package ac.ucsc.uitest.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class
                .getResourceAsStream("/config.properties")) {

            if (input == null) {
                throw new IllegalStateException(
                        "config.properties was not found in src/main/resources"
                );
            }

            properties.load(input);

        } catch (IOException e) {
            throw new IllegalStateException(
                    "Failed to load config.properties", e
            );
        }
    }

    private ConfigReader() {
        // Prevent creating ConfigReader objects
    }

    public static String getBaseUrl() {
        return getRequiredProperty("base.url");
    }

    public static long getExplicitWaitSeconds() {
        return Long.parseLong(
                getRequiredProperty("explicit.wait.seconds")
        );
    }

    private static String getRequiredProperty(String key) {
        String value = properties.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new IllegalStateException(
                    "Missing or empty configuration property: " + key
            );
        }

        return value.trim();
    }
}