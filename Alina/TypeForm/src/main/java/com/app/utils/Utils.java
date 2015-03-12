package com.app.utils;

import org.openqa.selenium.By;


public class Utils {










    /*
     * The method picks a string by its key from the file and reads its locatorType and locatorValue
     * It returns a By locator for the WebElement from UI mapping file
     */
    public static By getLocatorByType(String locator) {
        String[] splitValue = locator.split("\"");
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
