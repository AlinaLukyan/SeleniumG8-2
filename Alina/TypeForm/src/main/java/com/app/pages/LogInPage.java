package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogInPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = ".//input[@id='_username']")
    WebElement username;

    @FindBy(how = How.XPATH, using = ".//input[@id='_password']")
    WebElement password;

    @FindBy(how = How.XPATH, using = ".//*[@id='btnlogin']")
    WebElement loginButton;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logIn(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }
}
