package com.app.pages;

import com.app.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;


public class ConfirmDeletePage {

    private WebDriver driver;

    private WebElement yesButton;
    private WebElement noButton;

    @Value("${ConfirmDeletePage.yesButton}")
    private String yesButtonLocator;
    @Value("${ConfirmDeletePage.noButton}")
    private String noButtonLocator;

    public ConfirmDeletePage(WebDriver driver) {
        this.driver = driver;
    }

    public void confirmDelete() {
        yesButton = driver.findElement(Utils.getLocatorByType(yesButtonLocator));
        yesButton.click();
    }

    public void cancelDelete() {
        noButton = driver.findElement(Utils.getLocatorByType(noButtonLocator));
        noButton.click();
    }

    public void setYesButton(WebElement yesButton) {
        this.yesButton = yesButton;
    }

    public void setNoButton(WebElement noButton) {
        this.noButton = noButton;
    }
}
