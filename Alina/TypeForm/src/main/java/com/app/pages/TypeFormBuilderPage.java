package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class TypeFormBuilderPage extends Header {

    @FindBy(how = How.XPATH, using = ".//*[@id='current-form']")
    WebElement formEntered;

    public TypeFormBuilderPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFormEntered(){
        return formEntered;
    }
}
