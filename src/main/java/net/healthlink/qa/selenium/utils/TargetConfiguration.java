package net.healthlink.qa.selenium.utils;

/**
 * Created by beden on 2/9/2017.
 */

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Environment specific configuration options (e.g. paths/usernames/URLs) that will change depending on which
 * environment is targeted can be accessed here. Make sure you are using the correct launch configuration or have specified
 * the property as a VM argument e.g. -Dconfiguration=release<br/>
 * The property values are stored in utils/configuration.{type}.properties
 */
public class TargetConfiguration {
    private static Properties properties;

    static {
        // We will use the 'test' as the default configuration if nothing is provided when launched
        String configuration = System.getProperty("configuration", "test");
        String configurationFile = "utils/configuration." + configuration + ".properties";
        System.out.println(configurationFile);
        properties = new Properties();
        InputStream stream = TargetConfiguration.class.getClassLoader().getResourceAsStream(configurationFile);
        try {
            properties.load(stream);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static String getLoginPage() {
        return properties.getProperty("LOGIN_URL");
    }

    public static String getUsername(){
        return properties.getProperty("USERNAME");
    }

    public static String getPassword(){
        return properties.getProperty("PASSWORD");
    }
}