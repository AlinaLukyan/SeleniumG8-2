package com.app.pages;

import com.app.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Value;


public class LogInPage {

    private WebDriver driver;

    @Value("${LogInPage.usernameInput}")
    private String userInputLocator;
    @Value("${LogInPage.passwordInput}")
    private String passwordInputLocator;
    @Value("${LogInPage.loginButton}")
    private String loginButtonLocator;

    private WebElement usernameInput;
    private WebElement passwordInput;
    private WebElement loginButton;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public NewFormPage logIn(String username, String password){

        usernameInput = driver.findElement(Utils.getLocatorByType(userInputLocator));
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput = driver.findElement(Utils.getLocatorByType(passwordInputLocator));
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton = driver.findElement(Utils.getLocatorByType(loginButtonLocator));
        loginButton.click();
        return new NewFormPage(driver);
    }

    public void setUserInputLocator(String userInputLocator) {
        this.userInputLocator = userInputLocator;
    }

    public void setPasswordInputLocator(String passwordInputLocator) {
        this.passwordInputLocator = passwordInputLocator;
    }

    public void setLoginButtonLocator(String loginButtonLocator) {
        this.loginButtonLocator = loginButtonLocator;
    }
}
