package com.app.pages;

import com.app.libs.ConfigData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class ConfirmDeletePage {

    WebDriver driver;

    private WebElement yesButton;
    private WebElement noButton;


    public ConfirmDeletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void confirmDelete() {
        yesButton = driver.findElement(ConfigData.ui("ConfirmDeletePage.yesButton"));
        yesButton.click();
    }

    public void cancelDelete() {
        noButton = driver.findElement(ConfigData.ui("ConfirmDeletePage.noButton"));
        noButton.click();
    }

}
