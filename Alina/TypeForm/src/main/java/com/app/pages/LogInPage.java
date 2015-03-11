package com.app.pages;

import com.app.libs.ConfigData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LogInPage {

    WebDriver driver;
//    WebElements elements;



//    ConfigData("LogInPage.usernameInput");

//    @FindBy(how = How.valueOf(ConfigData.ui("LogInPage.usernameInput"));

//    public static final String ui2 = "any";

    private WebElement usernameInput;
    private WebElement passwordInput;
    private WebElement loginButton;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
//        elements = new WebElements(driver);
    }

    public void logIn(String username, String password){
        usernameInput = driver.findElement(ConfigData.ui("LogInPage.usernameInput"));
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput = driver.findElement(ConfigData.ui("LogInPage.passwordInput"));
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton = driver.findElement(ConfigData.ui("LogInPage.loginButton"));
        loginButton.click();
    }
}
