package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogInPage {

    WebDriver driver;
//    WebElements elements;

    @FindBy(how = How.XPATH, using = ".//input[@id='_username']")
    WebElement usernameInput;

    @FindBy(how = How.XPATH, using = ".//input[@id='_password']")
    WebElement passwordInput;

    @FindBy(how = How.XPATH, using = ".//*[@id='btnlogin']")
    WebElement loginButton;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
//        elements = new WebElements(driver);
    }

    public void logIn(String username, String password){
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
