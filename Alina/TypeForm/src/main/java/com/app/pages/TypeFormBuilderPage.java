package com.app.pages;

import com.app.pages.questions.WelcomeScreenConstructorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class TypeFormBuilderPage extends Header {

    @FindBy(how = How.XPATH, using = ".//*[@id='current-form']")
    WebElement formEntered;

    @FindBy(how = How.XPATH, using = ".//*[@id='sidebar']//span[contains(@class,'admin-button green')]")
    WebElement welcomeScreenButton;

    public TypeFormBuilderPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFormEntered() {
        return formEntered;
    }

    public void addWelcomeScreen(String welcomeText) {
        System.out.println("Please, add new welcome text");

    }

    public WelcomeScreenConstructorPage enterWelcomeScreenConstructor() {
        welcomeScreenButton.click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
        return PageFactory.initElements(driver, WelcomeScreenConstructorPage.class);
    }
}
