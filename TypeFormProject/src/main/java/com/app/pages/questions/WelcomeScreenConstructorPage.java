package com.app.pages.questions;


import com.app.pages.TypeFormBuilderPage;
import com.app.utils.ConfigData;
import com.app.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WelcomeScreenConstructorPage {

    private WebDriver driver;
    private static final Logger LOG = LoggerFactory.getLogger(WelcomeScreenConstructorPage.class);

    private Utils utils;
    private WebDriverWait wait;

    private static final int MAX_DRIVER_WAIT = 80;

    private WebElement welcomeTextIFrame;
    private WebElement previewIFrame;
    private WebElement submitButton;
    private WebElement previewWelcomeText;
    private WebElement welcomeScreenHeaderText;

    private String welcomeTextIFrameLocator = "WelcomeScreenConstructorPage.welcomeTextIFrame";
    private String previewIFrameLocator = "WelcomeScreenConstructorPage.previewIFrame";
    private String submitButtonLocator = "WelcomeScreenConstructorPage.submitButton";
    private String previewWelcomeTextLocator = "WelcomeScreenConstructorPage.previewWelcomeText";
    private String welcomeScreenHeader = "WelcomeScreenConstructorPage.welcomeScreenHeaderText";
    private String welcomeTextInput = "WelcomeScreenConstructorPage.tinyMCEClass";

    public WelcomeScreenConstructorPage(WebDriver driver) {
        this.driver = driver;
        utils = new Utils(driver);
        wait = new WebDriverWait(driver, MAX_DRIVER_WAIT);
        PageFactory.initElements(driver, this);
    }

    public WelcomeScreenConstructorPage addWelcomeScreenText(String welcomeText) {
        welcomeTextIFrame = driver.findElement(ConfigData.ui(welcomeTextIFrameLocator));
        driver.switchTo().frame(welcomeTextIFrame);
        utils.setInnerHTML(welcomeTextInput, welcomeText);
        driver.switchTo().defaultContent();
        return this;
    }

    public TypeFormBuilderPage submitNewWelcomeScreen() {
        submitButton = driver.findElement(ConfigData.ui(submitButtonLocator));
        submitButton.click();
        return new TypeFormBuilderPage(driver);
    }

    public String getPreviewWelcomeText() {
        previewIFrame = driver.findElement(ConfigData.ui(previewIFrameLocator));
        driver.switchTo().frame(previewIFrame);
        previewWelcomeText = driver.findElement(ConfigData.ui(previewWelcomeTextLocator));
        return previewWelcomeText.getText();
    }

    public boolean isNewWelcomeScreenBuilderOpened() {
        welcomeScreenHeaderText = driver.findElement(ConfigData.ui(welcomeScreenHeader));
        if (welcomeScreenHeaderText != null)
            return true;
        else {
            return false;
        }
    }
}
