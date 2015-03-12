package com.app.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.app.libs.ConfigData.ui;


public class Utils {

    WebDriver driver;
    public static final int DEFAULT_WAIT = 30;

    public Utils(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * The method refreshes a current page
     */
    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void selectCheckBox(String checkBoxSetLocator, boolean checkBoxState) {
        WebElement checkBox = driver.findElement(ui(checkBoxSetLocator));
        boolean currentState = checkBox.isSelected();

        if((!currentState && checkBoxState) || (currentState && !checkBoxState)){
            checkBox.click();
            System.out.println("We've just modified the current checkbox state");
        }
        else {
            System.out.println("Nothing has been done to the checkbox with locator <" + checkBoxSetLocator + ">");
        }
    }

    /**
     * The method checks if an element is present on the page
     */
    public boolean isElementPresent(String elementLocator) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        boolean result = driver.findElements(ui(elementLocator)).size() > 0;
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT, TimeUnit.SECONDS);
        return result;
//        try {
//            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//            driver.findElement(By.xpath(elementLocator));
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        } finally {
//            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        }
    }

    /**
     * The method implements selecting elements from a drop-down list
     */
    public void selectFromDropDown(String selectButtonLocator, String elementListLocator, String elementText) {
        WebElement selectButton = driver.findElement(ui(selectButtonLocator));
        selectButton.click();

        List<WebElement> options = selectButton.findElements(ui(elementListLocator));
        for (WebElement element : options) {
            if (element.getText().equals(elementText)) {
                element.click();
                break;
            }
        }
    }

    /**
     * The method implements selecting a radio-button from a radio-button block
     */
    public void selectRadioButton(String radioElementsLocator, int option) {
        if (option <= 0) {
            throw new IndexOutOfBoundsException(option + " is less or equal ZERO");
        } else {
            List<WebElement> radioElements = driver.findElements(ui(radioElementsLocator));

            if (option > 0 && option <= radioElements.size()) {
                radioElements.get(option - 1).click();

            } else {
                throw new IndexOutOfBoundsException("Option " + option + " wasn't found");
            }
        }
    }

    /**
     * TODO
     */
    public void goToNextWindow() {
        String parentWindow = driver.getWindowHandle();
        for(String window : driver.getWindowHandles()) {  //returns a set
            driver.switchTo().window(window);
//            if (!element.isPresent)
//                return;
        }
        driver.switchTo().window(parentWindow);
        driver.close();
    }

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
