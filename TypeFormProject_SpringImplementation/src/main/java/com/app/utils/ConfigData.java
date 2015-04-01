package com.app.utils;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigData {                                                //new class created
    public static String cfgFile = "src/config.properties";                //class variable added (path to the file)
    public static String uiMappingFile = "src/UIMapping.properties";    //class variable added (path to the file)

    /*
     * Return value from .properties file
     */
    public static String getValueFromFile(String key, String fileName) {
        Properties p = new Properties(); //The Properties class represents a persistent set of properties. The Properties can be saved to a stream or loaded from a stream. Each key and its corresponding value in the property list is a string.
        // Create stream for reading from file
        FileInputStream cfg = null; //A FileInputStream obtains input bytes
        try {
            cfg = new FileInputStream(fileName);
            p.load(cfg);
            cfg.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception");
        } catch (IOException e) {
            System.out.println("IO exception");
        }
        // from a file in a file system. FileInputStream is meant for reading streams of raw bytes such as image data. For reading streams of characters, consider using FileReader.
        // Load Properties from input stream


        // Return value for the property
        return (p.getProperty(key));
    }

    /*
     * Return value from UI mapping file. Note, please, that returned value is
     * String. We should take care of value's type by himself when will use
     * config data value in the test.
     */
    public static String getUiMappingValue(String key) {

        return (getValueFromFile(key, uiMappingFile));
    }

    /*
     * Return value from config file. Note, please, that returned value is
     * String. We should take care of value's type by himself when will use
     * config data value in the test.
     */
    public static String getCfgValue(String key) {

        return (getValueFromFile(key, cfgFile));
    }

    /*
     * Return By class with finding method and target for WebElement from UI mapping file
     */
    public static By ui(String key) {
        // Get WebElement's locator from UI mapping file and divide it to
        // finding method and target
        String[] partsOfLocator = new String[0];
        partsOfLocator = getValueFromFile(key, uiMappingFile).split(
                "\"");
        String findMethod = partsOfLocator[0].substring(0,
                partsOfLocator[0].length() - 1);
        String target = partsOfLocator[1];

        // Return By class with appropriate method and target
        if (findMethod.equals("xpath"))
            return By.xpath(target);
        else if (findMethod.equals("id"))
            return By.id(target);
        else if (findMethod.equals("name"))
            return By.name(target);
        else if (findMethod.equals("linkText"))
            return By.linkText(target);
        else if (findMethod.equals("tagName"))
            return By.tagName(target);
        else if (findMethod.equals("className"))
            return By.className(target);
        else if (findMethod.equals("cssSelector"))
            return By.cssSelector(target);
        else
            return By.partialLinkText(target);

    }
}