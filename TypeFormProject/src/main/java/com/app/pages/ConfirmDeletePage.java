package com.app.pages;

import com.app.utils.ConfigData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ConfirmDeletePage {

    private WebDriver driver;

    private WebElement yesButton;
    private WebElement noButton;

    private String yesButtonLocator = "ConfirmDeletePage.yesButton";
    private String noButtonLocator = "ConfirmDeletePage.noButton";

    public ConfirmDeletePage(WebDriver driver) {
        this.driver = driver;
    }

    public void confirmDelete() {
        yesButton = driver.findElement(ConfigData.ui(yesButtonLocator));
        yesButton.click();
    }

    public void cancelDelete() {
        noButton = driver.findElement(ConfigData.ui(noButtonLocator));
        noButton.click();
    }

}
