package com.app.pages;

import com.app.libs.ConfigData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class Header {

    WebDriver driver;

    private WebElement logoHome = driver.findElement(ConfigData.ui("Header.logoHome"));
    private WebElement userProfileMenu = driver.findElement(ConfigData.ui("Header.userProfileMenu"));
    private WebElement sighOutButton = driver.findElement(ConfigData.ui("Header.sighOutButton"));


    public Header(WebDriver driver){
        this.driver = driver;
    }

    public TypeFormPage goToHomePage(){
        logoHome.click();
        return PageFactory.initElements(driver, TypeFormPage.class);
    }

    public LogInPage logOut() {
        userProfileMenu.click();
        sighOutButton.click();
        return PageFactory.initElements(driver, LogInPage.class);
    }
}
