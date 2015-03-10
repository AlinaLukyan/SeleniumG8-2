package com.app.pages;

import com.app.libs.ConfigData;
import com.app.pages.questions.WelcomeScreenConstructorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class TypeFormBuilderPage extends Header {

    WebElement formEntered = driver.findElement(ConfigData.ui("TypeFormBuilderPage.formEntered"));
    WebElement welcomeScreenButton = driver.findElement(ConfigData.ui("TypeFormBuilderPage.welcomeScreenButton"));

    public TypeFormBuilderPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFormEntered() {
        return formEntered;
    }

    public void addWelcomeScreen(String welcomeText) {
        System.out.println("Please, add new welcome text");

    }

    public WelcomeScreenConstructorPage enterWelcomeScreenConstructor() {
        welcomeScreenButton.click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        return PageFactory.initElements(driver, WelcomeScreenConstructorPage.class);
    }
}
