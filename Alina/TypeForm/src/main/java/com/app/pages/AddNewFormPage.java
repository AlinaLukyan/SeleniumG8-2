package com.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddNewFormPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = ".//*[@id='quickyform_name']")
    WebElement formNameInput;

    @FindBy(how = How.XPATH, using = "//*[@id='s2id_quickyform_language']/a/div/b")
    WebElement formLanguageSelectButton;

    @FindBy(how = How.XPATH, using = ".//*[@id='s2id_quickyform_category']/a/div/b")
    WebElement formTypeSelectButton;

    @FindBy(how = How.XPATH, using = ".//*[@id='add-form']/form/div[4]/input")
    WebElement buildButton;


    public AddNewFormPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AddNewFormPage withFormName(String formName){
        formNameInput.clear();
        formNameInput.sendKeys(formName);
        return this;
    }

    public AddNewFormPage withFormLanguage(String formLanguage){
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

    public AddNewFormPage withFormType(String formType){
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
