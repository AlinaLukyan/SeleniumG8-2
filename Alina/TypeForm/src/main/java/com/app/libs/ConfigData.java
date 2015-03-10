package com.app.libs;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/*
 *  That class provides static methods for getting values from Config and UI mapping files
 */
public class ConfigData {												//new class created
    public static String cfgFile = "src/config.properties";				//class variable added (path to the file) - DB
    public static String uiMappingFile = "src/UIMapping.properties";	//class variable added (path to the file)

    private enum Locator {
        ID,
        XPATH,
        NAME,
        LINKTEXT,
        TAGNAME,
        CLASSNAME,
        CSSSELECTOR,
        PARTIALLINKTEXT
    }

    /*
     * Return value from .properties file
     */
    public static String getValueFromFile(String key, String fileName) //getter
            throws IOException {
        Properties p = new Properties(); //The Properties class represents a persistent set of properties. The Properties can be saved to a stream or loaded from a stream. Each key and its corresponding value in the property list is a string.
        // Create stream for reading from file
        FileInputStream cfg = new FileInputStream(fileName); //A FileInputStream obtains input bytes
        // from a file in a file system. FileInputStream is meant for reading streams of raw bytes such as image data. For reading streams of characters, consider using FileReader.
        // Load Properties from input stream
        p.load(cfg);
        cfg.close();

        // Return value for the property
        return (p.getProperty(key));
    }

    /*
     * Return value from UI mapping file. Note, please, that returned value is
     * String. We should take care of value's type by himself when will use
     * config data value in the test.
     */
    public static String getUiMappingValue(String key) throws IOException {

        return (getValueFromFile(key, uiMappingFile));
    }

    /*
     * Return value from config file. Note, please, that returned value is
     * String. We should take care of value's type by himself when will use
     * config data value in the test.
     */
    public static String getCfgValue(String key) throws IOException {

        return (getValueFromFile(key, cfgFile));
    }

    /*
     * Return By class with finding method and target for WebElement from UI mapping file
     */
    public static By ui(String key) throws IOException, ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        // Get WebElement's locator from UI mapping file and divide it to
        // finding method and target
        String[] partsOfLocator = getValueFromFile(key, uiMappingFile).split(
                "\"");
        String findMethod = partsOfLocator[0].substring(0,
                partsOfLocator[0].length() - 1);
        String target = partsOfLocator[1];

        // Return By class with appropriate method and target

        Locator currentLocator = Locator.valueOf(findMethod.toUpperCase());

        By currentBy = null;

        switch (currentLocator) {
            case ID:
                currentBy = By.id(target);
                break;
            case XPATH:
                currentBy = By.xpath(target);
                break;
            case NAME:
                currentBy = By.name(target);
                break;
            case TAGNAME:
                currentBy = By.tagName(target);
                break;
            case CLASSNAME:
                currentBy = By.className(target);
                break;
            case CSSSELECTOR:
                currentBy = By.cssSelector(target);
                break;
            case LINKTEXT:
                currentBy = By.linkText(target);
                break;
            case PARTIALLINKTEXT:
                currentBy = By.partialLinkText(target);
        }
        return currentBy;
    }
}