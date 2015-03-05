package com.app.pages.questions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomeScreenConstructorPage {

    WebDriver driver;
    WebDriverWait wait;

//    @FindBy(how = How.XPATH, using = "//textarea[@id='intro_body']")
//    @FindBy(how = How.XPATH, using ="//textarea[text()='Welcome text goes here']")

    @FindBy(how = How.XPATH, using = "//*[text()='Welcome text goes here']/..")
    WebElement welcomeTextField;

    @FindBy(how = How.XPATH, using = ".//a[@id='submit']")
    WebElement submitButton;

    @FindBy(how = How.XPATH, using = "//*[@id='intro_body_tbl']//td[@class='mceIframeContainer mceFirst mceLast focus']")

            //.//*[@id='preview']//div[@class='content-wrapper']//div[@class='text']
            //
    WebElement previewWelcomeText;

    public WelcomeScreenConstructorPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 800);
    }

    public void addNewWelcomeScreen(String welcomeText) {
//        wait.until(ExpectedConditions.visibilityOf(welcomeTextField));

//        welcomeTextField.sendKeys(Keys.chord(Keys.CONTROL, "a"), welcomeText);
        welcomeTextField.clear();
        welcomeTextField.sendKeys(welcomeText);
        submitButton.click();
    }

    public String getPreviewWelcomeText() {
        return previewWelcomeText.getText();
    }
}
