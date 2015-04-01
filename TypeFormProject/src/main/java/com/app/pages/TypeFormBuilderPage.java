package com.app.pages;

import com.app.pages.questions.ShortTextQuestionPage;
import com.app.pages.questions.WelcomeScreenConstructorPage;
import com.app.utils.ConfigData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class TypeFormBuilderPage {

    private WebDriver driver;
    private WebElement formEntered;
    private WebElement welcomeScreenButton;
    private WebElement dragAndDropSpot;
    private WebElement welcomeScreenText;
    private WebElement shortTextButton;

    private Actions actions;

    private String formEnteredLocator = "TypeFormBuilderPage.formEntered";
    private String welcomeScreenButtonLocator = "TypeFormBuilderPage.welcomeScreenButton";
    private String dragAndDropSpotLocator = "TypeFormBuilderPage.dragAndDropSpot";
    private String welcomeScreenTextLocator = "TypeFormBuilderPage.welcomeScreenText";
    private String shortTextButtonLocator = "TypeFormBuilderPage.shortTextButton";

    public TypeFormBuilderPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    public WebElement getFormEntered() {
        formEntered = driver.findElement(ConfigData.ui(formEnteredLocator));
        return formEntered;
    }

    public WelcomeScreenConstructorPage enterWelcomeScreenConstructor() {
        welcomeScreenButton = driver.findElement(ConfigData.ui(welcomeScreenButtonLocator));
        welcomeScreenButton.click();
        return new WelcomeScreenConstructorPage(driver);
    }

    public ShortTextQuestionPage enterShortTextQuestionConstructor() {
        shortTextButton = driver.findElement(ConfigData.ui(shortTextButtonLocator));
        shortTextButton.click();
        return new ShortTextQuestionPage(driver);
    }

    public WelcomeScreenConstructorPage dragAndDropWelcomeScreen() {
        welcomeScreenButton = driver.findElement(ConfigData.ui(welcomeScreenButtonLocator));
        dragAndDropSpot = driver.findElement(ConfigData.ui(dragAndDropSpotLocator));
        actions.dragAndDrop(welcomeScreenButton, dragAndDropSpot).build().perform();
        return new WelcomeScreenConstructorPage(driver);
    }

    public String getWelcomeScreenText() {
        welcomeScreenText = driver.findElement(ConfigData.ui(welcomeScreenTextLocator));
        return welcomeScreenText.getText();
    }
}

