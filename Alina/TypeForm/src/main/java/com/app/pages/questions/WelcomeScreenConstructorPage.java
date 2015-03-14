package com.app.pages.questions;


import com.app.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;

public class WelcomeScreenConstructorPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "//iframe[@id='intro_body_ifr']")
//    @FindBy(how = How.XPATH, using = "//iframe[@id='preview']")
    WebElement textIFrame;

    @FindBy(how = How.XPATH, using = "//iframe[@id='preview']")
    WebElement previewIFrame;

    @FindBy(how = How.XPATH, using = ".//*[@id='tinymce']")
//    @FindBy(how = How.XPATH, using = "//*[@id='typeform']/div[2]/div[1]/div/div[2]")
    WebElement welcomeTextArea;

    @FindBy(how = How.XPATH, using = ".//a[@id='submit']")
    WebElement submitButton;

    @FindBy(how = How.XPATH, using = ".//*[@id='typeform']/div[2]/div[1]/div/div[2]")
    WebElement previewWelcomeText;

    WebElement welcomeScreenHeaderText;

    @Value("${WelcomeScreenConstructorPage.welcomeScreenHeaderText}")
    private String welcomeScreenHeader;

    public WelcomeScreenConstructorPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 800);
        PageFactory.initElements(driver, this);
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
}
