package com.app.pages.questions;


import com.app.pages.TypeFormBuilderPage;
import com.app.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class WelcomeScreenConstructorPage {

    private WebDriver driver;
    private static final Logger LOG = LoggerFactory.getLogger(WelcomeScreenConstructorPage.class);

    @Autowired
    private Utils utils;
    @Autowired
    private WebDriverWait wait;
    @Autowired
    TypeFormBuilderPage typeFormBuilderPage;

    private WebElement welcomeTextIFrame;
    private WebElement previewIFrame;
    private WebElement submitButton;
    private WebElement previewWelcomeText;
    private WebElement welcomeScreenHeaderText;

    @Value("${WelcomeScreenConstructorPage.welcomeTextIFrame}")
    private String welcomeTextIFrameLocator;
    @Value("${WelcomeScreenConstructorPage.previewIFrame}")
    private String previewIFrameLocator;
    @Value("${WelcomeScreenConstructorPage.submitButton}")
    private String submitButtonLocator;
    @Value("${WelcomeScreenConstructorPage.previewWelcomeText}")
    private String previewWelcomeTextLocator;
    @Value("${WelcomeScreenConstructorPage.welcomeScreenHeaderText}")
    private String welcomeScreenHeader;
    @Value("${WelcomeScreenConstructorPage.tinyMCEClass}")
    private String welcomeTextInput;

    public WelcomeScreenConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    public WelcomeScreenConstructorPage addWelcomeScreenText(String welcomeText) {
        welcomeTextIFrame = driver.findElement(Utils.getLocatorByType(welcomeTextIFrameLocator));
        driver.switchTo().frame(welcomeTextIFrame);
        utils.setInnerHTML(welcomeTextInput, welcomeText);

        driver.switchTo().defaultContent();
        return this;
    }

    public TypeFormBuilderPage submitNewWelcomeScreen() {
        submitButton = driver.findElement(Utils.getLocatorByType(submitButtonLocator));
        submitButton.click();
        return typeFormBuilderPage;
    }

    public String getPreviewWelcomeText() {
        previewIFrame = driver.findElement(Utils.getLocatorByType(previewIFrameLocator));
        driver.switchTo().frame(previewIFrame);
        previewWelcomeText = driver.findElement(Utils.getLocatorByType(previewWelcomeTextLocator));
        return previewWelcomeText.getText();
    }

    public boolean isNewWelcomeScreenBuilderOpened() {
        welcomeScreenHeaderText = driver.findElement(Utils.getLocatorByType(welcomeScreenHeader));
        if (welcomeScreenHeaderText != null)
            return true;
        else {
            return false;
        }
    }

    public void setPreviewIFrameLocator(String previewIFrameLocator) {
        this.previewIFrameLocator = previewIFrameLocator;
    }

    public void setSubmitButtonLocator(String submitButtonLocator) {
        this.submitButtonLocator = submitButtonLocator;
    }

    public void setPreviewWelcomeTextLocator(String previewWelcomeTextLocator) {
        this.previewWelcomeTextLocator = previewWelcomeTextLocator;
    }

    public void setWelcomeScreenHeader(String welcomeScreenHeader) {
        this.welcomeScreenHeader = welcomeScreenHeader;
    }

    public void setWelcomeTextIFrameLocator(String welcomeTextIFrameLocator) {
        this.welcomeTextIFrameLocator = welcomeTextIFrameLocator;
    }

    public void setWelcomeTextInput(String welcomeTextInput) {
        this.welcomeTextInput = welcomeTextInput;
    }
}
