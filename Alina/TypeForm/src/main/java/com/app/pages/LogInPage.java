package com.app.pages;

import com.app.libs.ConfigData;
import com.app.libs.WebElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LogInPage {

    WebDriver driver;
    WebElements elements;

    private WebElement usernameInput = driver.findElement(ConfigData.ui("LogInPage.usernameInput"));
    private WebElement passwordInput = driver.findElement(ConfigData.ui("LogInPage.passwordInput"));
    private WebElement loginButton = driver.findElement(ConfigData.ui("LogInPage.loginButton"));

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        elements = new WebElements(driver);
    }

    public void logIn(String username, String password){
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
