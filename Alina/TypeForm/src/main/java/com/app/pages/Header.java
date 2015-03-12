package com.app.pages;

import com.app.libs.ConfigData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class Header {

    WebDriver driver;

    private WebElement logoHome;
    private WebElement userProfileMenu;
    private WebElement sighOutButton;


    public Header(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    private void initElements() {
//        logoHome = driver.findElement(ConfigData.ui("Header.logoHome"));
//        userProfileMenu = driver.findElement(ConfigData.ui("Header.userProfileMenu"));
//        sighOutButton = driver.findElement(ConfigData.ui("Header.sighOutButton"));
//    }

    public TypeFormPage goToHomePage(){
        logoHome = driver.findElement(ConfigData.ui("Header.logoHome"));
        logoHome.click();
        return new TypeFormPage(driver);
    }

    public LogInPage logOut() {
        userProfileMenu = driver.findElement(ConfigData.ui("Header.userProfileMenu"));
        userProfileMenu.click();
        sighOutButton = driver.findElement(ConfigData.ui("Header.sighOutButton"));
        sighOutButton.click();
        return new LogInPage(driver);
    }
}
