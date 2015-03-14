package com.app.pages.questions;


import com.app.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class WelcomeScreenConstructorPage {

    WebDriver driver;

    @Autowired
    WebDriverWait wait;

    WebElement textIFrame;
    WebElement previewIFrame;
    WebElement welcomeTextArea;
    WebElement submitButton;
    WebElement previewWelcomeText;
    WebElement welcomeScreenHeaderText;

    @Value("${WelcomeScreenConstructorPage.textIFrame}")
    private String textIFrameLocator;
    @Value("${WelcomeScreenConstructorPage.previewIFrame}")
    private String previewIFrameLocator;
    @Value("${WelcomeScreenConstructorPage.welcomeTextArea}")
    private String welcomeTextAreaLocator;
    @Value("${WelcomeScreenConstructorPage.submitButton}")
    private String submitButtonLocator;
    @Value("${WelcomeScreenConstructorPage.previewWelcomeText}")
    private String previewWelcomeTextLocator;
    @Value("${WelcomeScreenConstructorPage.welcomeScreenHeaderText}")
    private String welcomeScreenHeader;

    public WelcomeScreenConstructorPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 800);
    }

    public void addNewWelcomeScreen(String welcomeText) {
//        List<WebElement> iFrames = driver.findElements(By.tagName("iframe"));
//        WebElement startButton = driver.findElement(By.xpath(".//*[@id='typeform']/div[2]/div[1]/div/div[4]/div[1]"));
        driver.switchTo().frame(textIFrame);
        WebElement welcomeTextArea = driver.findElement(By.xpath(".//*[@id='tinymce']"));
//        startButton.click();
        welcomeTextArea.clear();
        WebElement text = driver.findElement(By.xpath("//textarea[@id='intro_body']"));
        text.sendKeys("New text");
        driver.switchTo().defaultContent();
//        wait.until(ExpectedConditions.visibilityOf(welcomeTextField));
//        welcomeTextField.sendKeys(Keys.chord(Keys.CONTROL, "a"), welcomeText);
//        submitButton.click();
//        driver.switchto.defaultcontent();
    }

    public String getPreviewWelcomeText() {
        driver.switchTo().frame(previewIFrame);
        return previewWelcomeText.getText();
    }

    public boolean isNewWelcomeScreenBuilderOpened() {
        welcomeScreenHeaderText = driver.findElement(Utils.getLocatorByType(welcomeScreenHeader));
        if (welcomeScreenHeaderText != null)
            return true;
        else
            return false;
    }

    public void setTextIFrameLocator(String textIFrameLocator) {
        this.textIFrameLocator = textIFrameLocator;
    }

    public void setPreviewIFrameLocator(String previewIFrameLocator) {
        this.previewIFrameLocator = previewIFrameLocator;
    }

    public void setWelcomeTextAreaLocator(String welcomeTextAreaLocator) {
        this.welcomeTextAreaLocator = welcomeTextAreaLocator;
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
}
