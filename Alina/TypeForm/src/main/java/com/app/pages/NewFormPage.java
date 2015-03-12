package com.app.pages;

import com.app.libs.ConfigData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewFormPage {

    WebDriver driver;

    WebElement formNameInput;
    WebElement formLanguageSelectButton;
    WebElement formTypeSelectButton;
    WebElement buildButton;

    public NewFormPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    private void initElements() {
//        formNameInput = driver.findElement(ConfigData.ui("NewFormPage.formNameInput"));
//        formLanguageSelectButton = driver.findElement(ConfigData.ui("NewFormPage.formLanguageSelectButton"));
//        formTypeSelectButton = driver.findElement(ConfigData.ui("NewFormPage.formTypeSelectButton"));
//        buildButton = driver.findElement(ConfigData.ui("NewFormPage.buildButton"));
//    }

    public NewFormPage withFormName(String formName){
        formNameInput = driver.findElement(ConfigData.ui("NewFormPage.formNameInput"));
        formNameInput.clear();
        formNameInput.sendKeys(formName);
        return this;
    }

    public NewFormPage withFormLanguage(String formLanguage){
        formLanguageSelectButton = driver.findElement(ConfigData.ui("NewFormPage.formLanguageSelectButton"));
        formLanguageSelectButton.click();
        List<WebElement> options = formLanguageSelectButton.findElements(By.xpath("//div[@class='select2-result-label']"));
        for (WebElement element : options){
            if(element.getText().equals(formLanguage)) {
                element.click();
                break;
            }
        }
        return this;
    }

    public NewFormPage withFormType(String formType){
        formTypeSelectButton = driver.findElement(ConfigData.ui("NewFormPage.formTypeSelectButton"));
        formTypeSelectButton.click();
        List<WebElement> options = formTypeSelectButton.findElements(By.xpath("//div[@class='select2-result-label']"));
        for (WebElement element : options) {
            if (element.getText().equals(formType)) {
                element.click();
                break;
            }
        }
        return this;
    }

    public TypeFormBuilderPage openFormBuilderPage(){
        buildButton = driver.findElement(ConfigData.ui("NewFormPage.buildButton"));
        buildButton.click();
        return PageFactory.initElements(driver, TypeFormBuilderPage.class);
    }
}
