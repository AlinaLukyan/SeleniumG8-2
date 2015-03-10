package com.app.pages;

import com.app.libs.ConfigData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ConfirmDeletePage {

    WebDriver driver;

    private WebElement yesButton = driver.findElement(ConfigData.ui("ConfirmDeletePage.yesButton"));
    private WebElement noButton = driver.findElement(ConfigData.ui("ConfirmDeletePage.noButton"));


    public ConfirmDeletePage(WebDriver driver) {
        this.driver = driver;
    }

    public void confirmDelete() {
        yesButton.click();
    }

    public void cancelDelete() {
        noButton.click();
    }

}
