package com.app.pages;

import com.app.utils.ConfigData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogInPage {

    private WebDriver driver;
    private final static Logger LOG = LoggerFactory.getLogger(LogInPage.class);

    private WebElement usernameInput;
    private WebElement passwordInput;
    private WebElement loginButton;

    private String usernameInputLocator = "LogInPage.usernameInput";
    private String passwordInputLocator = "LogInPage.passwordInput";
    private String loginButtonLocator = "LogInPage.loginButton";

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    public NewFormPage logIn(String username, String password){
        LOG.debug(this.toString());
        usernameInput = driver.findElement(ConfigData.ui(usernameInputLocator));
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput = driver.findElement(ConfigData.ui(passwordInputLocator));
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton = driver.findElement(ConfigData.ui(loginButtonLocator));
        loginButton.click();
        return new NewFormPage(driver);
    }

    @Override
    public String toString() {
        return "LogInPage{" +
                "driver=" + driver +
                ", usernameInput=" + usernameInput +
                ", passwordInput=" + passwordInput +
                ", loginButton=" + loginButton +
                '}';
    }
}
