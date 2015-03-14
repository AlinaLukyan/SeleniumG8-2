package com.app.pages;

import com.app.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class Header {

    private final static Logger LOG = LoggerFactory.getLogger(Header.class);

    private WebDriver driver;

    private WebElement logoHome;
    private WebElement userProfileMenu;
    private WebElement sighOutButton;

    @Value("${Header.logoHome}")
    private String logoHomeLocator;
    @Value("${Header.userProfileMenu}")
    private String userProfileMenuLocator;
    @Value("${Header.sighOutButton}")
    private String sighOutButtonLocator;

    public Header(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TypeFormPage goToHomePage(){
        logoHome = driver.findElement(Utils.getLocatorByType(logoHomeLocator));
        logoHome.click();
        return new TypeFormPage(driver);
    }

    public LogInPage logOut() {
        LOG.debug(this.toString());
        userProfileMenu = driver.findElement(Utils.getLocatorByType(userProfileMenuLocator));
        userProfileMenu.click();
        sighOutButton = driver.findElement(Utils.getLocatorByType(sighOutButtonLocator));
        sighOutButton.click();
        return new LogInPage(driver);
    }

    public void setLogoHomeLocator(String logoHomeLocator) {
        this.logoHomeLocator = logoHomeLocator;
    }

    public void setUserProfileMenuLocator(String userProfileMenuLocator) {
        this.userProfileMenuLocator = userProfileMenuLocator;
    }

    public void setSighOutButtonLocator(String sighOutButtonLocator) {
        this.sighOutButtonLocator = sighOutButtonLocator;
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
