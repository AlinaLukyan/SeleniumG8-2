package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class ConfirmDeletePage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[@id='dialog-ok']")
    WebElement yesButton;

    @FindBy(how = How.XPATH, using = "//a[@id='dialog-cancel']")
    WebElement noButton;

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
