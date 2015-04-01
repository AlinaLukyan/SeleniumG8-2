package com.app.pages;

import com.app.utils.ConfigData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Header {

    private final static Logger LOG = LoggerFactory.getLogger(Header.class);

    private WebDriver driver;

    private WebElement logoHome;
    private WebElement userProfileMenu;
    private WebElement sighOutButton;

    private String logoHomeLocator = "Header.logoHome";
    private String userProfileMenuLocator = "Header.userProfileMenu";
    private String sighOutButtonLocator = "Header.sighOutButton";

    public Header(WebDriver driver){
        this.driver = driver;
    }

    public TypeFormPage goToHomePage(){
        logoHome = driver.findElement(ConfigData.ui(logoHomeLocator));
        logoHome.click();
        return new TypeFormPage(driver);
    }

    public LogInPage logOut() {
        LOG.debug(this.toString());
        userProfileMenu = driver.findElement(ConfigData.ui(userProfileMenuLocator));
        userProfileMenu.click();
        sighOutButton = driver.findElement(ConfigData.ui(sighOutButtonLocator));
        sighOutButton.click();
        return new LogInPage(driver);
    }

    @Override
    public String toString() {
        return "Header{" +
                "driver=" + driver +
                ", logoHome=" + logoHome +
                ", userProfileMenu=" + userProfileMenu +
                ", sighOutButton=" + sighOutButton +
                ", logoHomeLocator='" + logoHomeLocator + '\'' +
                ", userProfileMenuLocator='" + userProfileMenuLocator + '\'' +
                ", sighOutButtonLocator='" + sighOutButtonLocator + '\'' +
                '}';
    }
}
