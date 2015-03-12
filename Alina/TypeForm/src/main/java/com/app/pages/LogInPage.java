package com.app.pages;

import com.app.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.InitializingBean;


public class LogInPage implements InitializingBean {

    WebDriver driver;
//    WebElements elements;



//    ConfigData("LogInPage.usernameInput");

//    @FindBy(how = How.valueOf(ConfigData.ui("LogInPage.usernameInput"));

//    public static final String ui2 = "any";

    private WebElement usernameInput;
    private WebElement passwordInput;
    private WebElement loginButton;

    private String userInputLocator;
    private String passwordInputLocator;
    private String loginButtonLocator;


    public LogInPage(WebDriver driver) {
        this.driver = driver;
//        elements = new WebElements(driver);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    public void logIn(String username, String password){
        usernameInput = driver.findElement(Utils.getLocatorByType(userInputLocator));
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput = driver.findElement(Utils.getLocatorByType(passwordInputLocator));
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton = driver.findElement(Utils.getLocatorByType(loginButtonLocator));
        loginButton.click();
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
