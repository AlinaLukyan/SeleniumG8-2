package com.app.pages;

import com.app.libs.ConfigData;
import com.app.pages.questions.WelcomeScreenConstructorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


public class TypeFormBuilderPage extends Header {

    WebElement formEntered;
    WebElement welcomeScreenButton;
    WebElement dragAndDropHereSpot;
    Actions actions;

    public TypeFormBuilderPage(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

//    private void initElements() {
//        formEntered = driver.findElement(ConfigData.ui("TypeFormBuilderPage.formEntered"));
//        welcomeScreenButton = driver.findElement(ConfigData.ui("TypeFormBuilderPage.welcomeScreenButton"));
//    }

    public WebElement getFormEntered() {
        formEntered = driver.findElement(ConfigData.ui("TypeFormBuilderPage.formEntered"));
        return formEntered;
    }

    public void addWelcomeScreen(String welcomeText) {
        System.out.println("Please, add new welcome text");
    }

    public WelcomeScreenConstructorPage enterWelcomeScreenConstructor() {
        welcomeScreenButton = driver.findElement(ConfigData.ui("TypeFormBuilderPage.welcomeScreenButton"));
        welcomeScreenButton.click();
        return new WelcomeScreenConstructorPage(driver);
    }

    public WelcomeScreenConstructorPage dragAndDropWelcomeScreen() {
        welcomeScreenButton = driver.findElement(ConfigData.ui("TypeFormBuilderPage.welcomeScreenButton"));
        dragAndDropHereSpot = driver.findElement(ConfigData.ui("TypeFormBuilderPage.dragAndDropHereSpot"));
        actions.dragAndDrop(welcomeScreenButton, dragAndDropHereSpot).build().perform();
        return new WelcomeScreenConstructorPage(driver);
    }
}
