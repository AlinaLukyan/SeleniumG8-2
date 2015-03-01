package com.app.libs;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/*
* This class implements methods to work with default web-elements
 */
public class WebElements {

    WebDriver driver;

    public WebElements(WebDriver driver){
        this.driver = driver;
    }

    public void inputTest(String fieldLocator, String text) {
        WebElement inputField = driver.findElement(By.xpath(fieldLocator));
        inputField.clear();
        inputField.sendKeys(text);
        System.out.println(text + " was inputted into a field with the locator <" + inputField + ">");
    }

    public void clearTextInput(String textLocator){
        driver.findElement(By.xpath(textLocator)).clear();
        System.out.println("Text was cleared from a field with the locator <" + textLocator + ">");
    }

    /**
     * The method clicks on a button by its locator
     */
    public void clickButton(String buttonLocator){
        driver.findElement(By.xpath(buttonLocator)).click();
        System.out.println("Button with locator <" + buttonLocator + "> was clicked");
    }

    /**
     * The method clicks on a link by its locator
     */
    public void clickLink(String linkLocator){
        driver.findElement(By.linkText(linkLocator)).click();
        System.out.println("Button with locator <" + linkLocator + "> was clicked");
    }

    public void selectCheckBox(By by, boolean checkBoxState){
        WebElement checkBox = driver.findElement(by);
        boolean currentState = checkBox.isSelected();

        if((!currentState && checkBoxState) || (currentState && !checkBoxState)){
            checkBox.click();
            System.out.println("We've just modified the current checkbox state");
        }
        else {
            System.out.println("Nothing has been done to the checkbox with locator <" + by + ">");
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
    private boolean isElementPresent(By by) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        boolean result = driver.findElements(by).size() > 0;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return result;

//        try {
//            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//            driver.findElement(by);
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        } finally {
//            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        }

    }



    //2. Select radio-button by its block
    //3. Select from drop-down


}
