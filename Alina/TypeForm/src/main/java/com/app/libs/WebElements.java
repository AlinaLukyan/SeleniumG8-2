package com.app.libs;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.app.libs.ConfigData.ui;

/*
* This class implements methods to work with default web-elements
 */
public class WebElements {

    WebDriver driver;

    public WebElements(WebDriver driver){
        this.driver = driver;
    }

    public void inputTest(String fieldLocator, String text) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
//        WebElement inputField = driver.findElement(By.xpath(fieldLocator));
        WebElement inputField = driver.findElement(ui(fieldLocator));
        inputField.clear();
        inputField.sendKeys(text);
        System.out.println(text + " was inputted into a field with the locator <" + inputField + ">");
    }

    public void clearTextInput(String textLocator) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        driver.findElement(ui(textLocator)).clear();
        System.out.println("Text was cleared from a field with the locator <" + textLocator + ">");
    }

    /**
     * The method clicks on a button by its locator
     */
    public void clickButton(String buttonLocator) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        driver.findElement(ui(buttonLocator)).click();
        System.out.println("Button with locator <" + buttonLocator + "> was clicked");
    }

    /**
     * The method clicks on a link by its locator
     */
    public void clickLink(String linkLocator) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        driver.findElement(ui(linkLocator)).click();
        System.out.println("Button with locator <" + linkLocator + "> was clicked");
    }

    public void selectCheckBox(String checkBoxSetLocator, boolean checkBoxState) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
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

    public void openUrl(String url){
        //providing a browser type might be a good solution
        driver.manage().window().maximize();
        driver.get(url);
    }

    /**
     * The method refreshes a current page
     */
    public void refreshPage() {
        driver.get(driver.getCurrentUrl());
    }

    /**
     * The method checks if an element is present on the page
     */
    public boolean isElementPresent(String elementLocator) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        boolean result = driver.findElements(ui(elementLocator)).size() > 0;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
    public void selectFromDropDown(String selectButtonLocator, String elementListLocator, String elementText) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
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
    public void selectRadioButton(String radioElementsLocator, int option) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
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
}
