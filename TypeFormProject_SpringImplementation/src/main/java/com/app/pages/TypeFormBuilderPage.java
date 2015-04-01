package com.app.pages;

import com.app.pages.questions.ShortTextQuestionPage;
import com.app.pages.questions.WelcomeScreenConstructorPage;
import com.app.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


public class TypeFormBuilderPage {

    private WebDriver driver;
    private WebElement formEntered;
    private WebElement welcomeScreenButton;
    private WebElement dragAndDropSpot;
    private WebElement welcomeScreenText;
    private WebElement shortTextButton;

    @Autowired
    private Actions actions;
    @Autowired
    private WelcomeScreenConstructorPage welcomeScreenConstructorPage;
    @Autowired
    private ShortTextQuestionPage shortTextQuestionPage;

    @Value("${TypeFormBuilderPage.formEntered}")
    private String formEnteredLocator;
    @Value("${TypeFormBuilderPage.welcomeScreenButton}")
    private String welcomeScreenButtonLocator;
    @Value("${TypeFormBuilderPage.dragAndDropSpot}")
    private String dragAndDropSpotLocator;
    @Value("${TypeFormBuilderPage.welcomeScreenText}")
    private String welcomeScreenTextLocator;
    @Value("${TypeFormBuilderPage.shortTextButton}")
    private String shortTextButtonLocator;

    public TypeFormBuilderPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFormEntered() {
        formEntered = driver.findElement(Utils.getLocatorByType(formEnteredLocator));
        return formEntered;
    }

    public WelcomeScreenConstructorPage enterWelcomeScreenConstructor() {
        welcomeScreenButton = driver.findElement(Utils.getLocatorByType(welcomeScreenButtonLocator));
        welcomeScreenButton.click();
        return welcomeScreenConstructorPage;
    }

    public ShortTextQuestionPage enterShortTextQuestionConstructor() {
        shortTextButton = driver.findElement(Utils.getLocatorByType(shortTextButtonLocator));
        shortTextButton.click();
        return shortTextQuestionPage;
    }

    public WelcomeScreenConstructorPage dragAndDropWelcomeScreen() {
        welcomeScreenButton = driver.findElement(Utils.getLocatorByType(welcomeScreenButtonLocator));
        dragAndDropSpot = driver.findElement(Utils.getLocatorByType(dragAndDropSpotLocator));
        actions.dragAndDrop(welcomeScreenButton, dragAndDropSpot).build().perform();
        return welcomeScreenConstructorPage;
    }

    public String getWelcomeScreenText() {
        welcomeScreenText = driver.findElement(Utils.getLocatorByType(welcomeScreenTextLocator));
        return welcomeScreenText.getText();
    }

    public void setFormEnteredLocator(String formEnteredLocator) {
        this.formEnteredLocator = formEnteredLocator;
    }

    public void setWelcomeScreenButtonLocator(String welcomeScreenButtonLocator) {
        this.welcomeScreenButtonLocator = welcomeScreenButtonLocator;
    }

    public void setDragAndDropSpotLocator(String dragAndDropSpotLocator) {
        this.dragAndDropSpotLocator = dragAndDropSpotLocator;
    }

    public void setWelcomeScreenTextLocator(String welcomeScreenTextLocator) {
        this.welcomeScreenTextLocator = welcomeScreenTextLocator;
    }

    public void setShortTextButtonLocator(String shortTextButtonLocator) {
        this.shortTextButtonLocator = shortTextButtonLocator;
    }
}

