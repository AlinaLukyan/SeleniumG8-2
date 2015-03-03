package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public abstract class Header {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id='logo']/img")
    WebElement logoHome;

    @FindBy(how = How.XPATH, using = "//*[@id='header']/div[1]/ul/li[2]/a/div")
    WebElement userProfileMenu;

    @FindBy(how = How.XPATH, using = "//a[@id='menu-logout']")
    WebElement sighOutButton;

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
