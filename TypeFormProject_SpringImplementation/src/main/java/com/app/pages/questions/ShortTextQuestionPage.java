package com.app.pages.questions;


import com.app.pages.TypeFormBuilderPage;
import com.app.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class ShortTextQuestionPage {

    private WebDriver driver;

    private WebElement submitButton;
    private WebElement shortTextIFrame;

    @Value("${ShortTextQuestionPage.tinyMCEClass}")
    private String questionInput;
    @Value("${ShortTextQuestionPage.submitButton}")
    private String submitButtonLocator;
    @Value("${ShortTextQuestionPage.shortTextIFrame}")
    private String shortTextIFrameLocator;
    
    @Autowired
    private Utils utils;
    @Autowired
    private TypeFormBuilderPage typeFormBuilderPage;

    public ShortTextQuestionPage(WebDriver driver) {
        this.driver = driver;
    }

    public ShortTextQuestionPage enterQuestionText(String shortText) {
        shortTextIFrame = driver.findElement(Utils.getLocatorByType(shortTextIFrameLocator));
        driver.switchTo().frame(shortTextIFrame);
        utils.setInnerHTML(questionInput, shortText);
        driver.switchTo().defaultContent();
        return this;
    }

    public TypeFormBuilderPage submitNewQuestion() {
        submitButton = driver.findElement(Utils.getLocatorByType(submitButtonLocator));
        submitButton.click();
        return typeFormBuilderPage;
    }

    public void setShortTextIFrameLocator(String shortTextIFrameLocator) {
        this.shortTextIFrameLocator = shortTextIFrameLocator;
    }

    public void setSubmitButtonLocator(String submitButtonLocator) {
        this.submitButtonLocator = submitButtonLocator;
    }

    public void setQuestionInput(String questionInput) {
        this.questionInput = questionInput;
    }
}
