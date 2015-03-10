package com.app.libs;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*
 *  That class provides static methods for getting values from Config and UI mapping files
 */
public class ConfigData {
    private static final String CONFIG_FILE = "src/config.properties";				//DB connection details, default values for waits
    private static final String UI_MAPPING_FILE = "src/UIMapping.properties";

    /*
     * Returns value from .properties file
     */
    public static String getValueFromFile(String key, String fileName) {

        // Property data can be saved to a stream or loaded from a stream.
        // Each key and its corresponding value in the property list is a string.

        Properties properties = new Properties();
        // Create stream for reading from file
        FileInputStream inputStream = null;

        try {
            // FileInputStream obtains input bytes from a file in a file system.
            // For reading streams of characters, consider using FileReader.
            inputStream = new FileInputStream(fileName);

            // Load Properties from input stream
            properties.load(inputStream);

        } catch (FileNotFoundException e) {
            Assert.fail(fileName + " not found");
        } catch (IOException e) {
            Assert.fail();
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace(); //log4j
                }
        }
        return properties.getProperty(key);
    }

    /*
     * Return value from UI mapping file. Note, please, that returned value is
     * String. We should take care of value's type by himself when will use
     * config data value in the test.
     */
    public static String getUiMappingValue(String key) {

        return (getValueFromFile(key, UI_MAPPING_FILE));
    }

    /*
     * Return value from config file. Note, please, that returned value is
     * String. We should take care of value's type by himself when will use
     * config data value in the test.
     */
    public static String getCfgValue(String key) {

        return (getValueFromFile(key, CONFIG_FILE));
    }

    /*
     * The method picks a string by its key from the file and reads its locatorType and locatorValue
     * It returns a By locator for the WebElement from UI mapping file
     */
    public static By ui(String key) {
        String[] splitValue = getValueFromFile(key, UI_MAPPING_FILE).split("\"");
        String locatorType = splitValue[0].substring(0, splitValue[0].length() - 1);
        String locatorValue = splitValue[1];

        By currentLocator = null;

        switch (locatorType) {
            case "id":
                currentLocator = By.id(locatorValue);
                break;
            case "xpath":
                currentLocator = By.xpath(locatorValue);
                break;
            case "name":
                currentLocator = By.name(locatorValue);
                break;
            case "tagName":
                currentLocator = By.tagName(locatorValue);
                break;
            case "className":
                currentLocator = By.className(locatorValue);
                break;
            case "cssSelector":
                currentLocator = By.cssSelector(locatorValue);
                break;
            case "linkText":
                currentLocator = By.linkText(locatorValue);
                break;
            case "partialLinkText":
                currentLocator = By.partialLinkText(locatorValue);
                break;
            default:
                System.out.println(locatorType + " locator is not supported");
        }
        return currentLocator;
    }
}