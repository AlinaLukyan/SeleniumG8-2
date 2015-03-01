package com.app.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TypeFormPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//ul[@id='forms']/li[contains(@class,'add admin-button')]")
    WebElement newTypeFormButton;

    @FindBy(how = How.XPATH, using = "//ul[@id='forms']/li[contains(@class,'quickyform item active')]")
    List<WebElement> activeForms;

    public TypeFormPage(WebDriver driver){
        this.driver = driver;
    }

    public int getTotalFormNumber() {
        return activeForms.size();
    }

    public AddNewFormPage addNewForm() {
        newTypeFormButton.click();
        return PageFactory.initElements(driver, AddNewFormPage.class);
    }

}
