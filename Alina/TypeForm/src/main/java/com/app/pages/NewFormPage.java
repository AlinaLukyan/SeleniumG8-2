package com.app.pages;

import com.app.libs.ConfigData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewFormPage {

    WebDriver driver;

    WebElement formNameInput = driver.findElement(ConfigData.ui("NewFormPage.formNameInput"));
    WebElement formLanguageSelectButton = driver.findElement(ConfigData.ui("NewFormPage.formLanguageSelectButton"));
    WebElement formTypeSelectButton = driver.findElement(ConfigData.ui("NewFormPage.formTypeSelectButton"));
    WebElement buildButton = driver.findElement(ConfigData.ui("NewFormPage.buildButton"));

    public NewFormPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public NewFormPage withFormName(String formName){
        formNameInput.clear();
        formNameInput.sendKeys(formName);
        return this;
    }

    public NewFormPage withFormLanguage(String formLanguage){
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
        buildButton.click();
        return PageFactory.initElements(driver, TypeFormBuilderPage.class);
    }
}
