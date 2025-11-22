package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProvider {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigProvider.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IOException("Unable to find config.properties");
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError("Failed to load configuration properties.");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getBaseUrl() {
        return getProperty("base.url");
    }

    public static int getTimeout() {
        return Integer.parseInt(getProperty("timeout"));
    }
}