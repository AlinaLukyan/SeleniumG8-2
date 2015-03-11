package com.app.pages;

import com.app.libs.ConfigData;
import com.app.libs.WebElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class Header {

    WebDriver driver;
    WebElements elements;

    private WebElement logoHome;
    private WebElement userProfileMenu;
    private WebElement sighOutButton;


    public Header(WebDriver driver){
        this.driver = driver;
//        initElements();
        PageFactory.initElements(driver, this);
        elements = new WebElements(driver);
    }

    private void initElements() {
        logoHome = driver.findElement(ConfigData.ui("Header.logoHome"));
        userProfileMenu = driver.findElement(ConfigData.ui("Header.userProfileMenu"));
        sighOutButton = driver.findElement(ConfigData.ui("Header.sighOutButton"));
    }

    public TypeFormPage goToHomePage(){
        logoHome = driver.findElement(ConfigData.ui("Header.logoHome"));
        logoHome.click();
        return new TypeFormPage(driver);
//        return PageFactory.initElements(driver, TypeFormPage.class);
    }

    public LogInPage logOut() {
        userProfileMenu = driver.findElement(ConfigData.ui("Header.userProfileMenu"));
        userProfileMenu.click();
        sighOutButton = driver.findElement(ConfigData.ui("Header.sighOutButton"));
        sighOutButton.click();
        return new LogInPage(driver);
//        return PageFactory.initElements(driver, LogInPage.class);
    }
}
