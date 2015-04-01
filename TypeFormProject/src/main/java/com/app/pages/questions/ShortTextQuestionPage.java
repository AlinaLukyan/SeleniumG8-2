package com.app.pages.questions;


import com.app.pages.TypeFormBuilderPage;
import com.app.utils.ConfigData;
import com.app.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ShortTextQuestionPage {

    private WebDriver driver;

    private WebElement submitButton;
    private WebElement shortTextIFrame;

    private String questionInput = "ShortTextQuestionPage.tinyMCEClass";
    private String submitButtonLocator = "ShortTextQuestionPage.submitButton";
    private String shortTextIFrameLocator = "ShortTextQuestionPage.shortTextIFrame";
    
    private Utils utils;

    public ShortTextQuestionPage(WebDriver driver) {
        this.driver = driver;
        utils = new Utils(driver);
        PageFactory.initElements(driver, this);
    }

    public ShortTextQuestionPage enterQuestionText(String shortText) {
        shortTextIFrame = driver.findElement(ConfigData.ui(shortTextIFrameLocator));
        driver.switchTo().frame(shortTextIFrame);
        utils.setInnerHTML(questionInput, shortText);
        driver.switchTo().defaultContent();
        return this;
    }

    public TypeFormBuilderPage submitNewQuestion() {
        submitButton = driver.findElement(ConfigData.ui(submitButtonLocator));
        submitButton.click();
        return new TypeFormBuilderPage(driver);
    }
}
